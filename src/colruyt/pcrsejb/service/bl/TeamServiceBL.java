package colruyt.pcrsejb.service.bl;

import java.util.Collection;
import java.util.HashSet;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.team.MemoryTeamService;
import colruyt.pcrsejb.service.dl.team.TeamService;
import colruyt.pcrsejb.util.exceptions.bl.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.validators.team.TeamValidator;
import org.apache.xpath.operations.Bool;

public class TeamServiceBL {
	
	private TeamService teamdb = new MemoryTeamService();
	private TeamValidator validator = new TeamValidator();
	/**
	 * Methode voor het toevoegen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void addTeamMemberToTeam(User teamMember, Team team) {
		addMemberToTeam(teamMember, team, new TeamMemberPrivilege());
	}
	
	/**
	 * Methode voor het maken van een teammanager
	 * 
	 * @param teammanager
	 */
	public void addManagerToTeam(User teamMember, Team team) {
		this.removeLeader(team);
		addMemberToTeam(teamMember, team, new TeamManagerPrivilege());
	}
	
	private void addMemberToTeam(User teamMember, Team team, Privilege privilege) {
		Enrolment enrollment = null;
		HashSet<Enrolment> enrollments = team.getEnrolmentsHashSet();
		for (Enrolment en : enrollments) {
			if (en.getUser().equals(teamMember)) {
				enrollment = en;
				enrollment.setPrivilege(privilege);
				enrollment.setActive(true);
			}
		}
		if (enrollment == null) {
			enrollment = new Enrolment(teamMember, privilege, true);
			enrollments.add(enrollment);
		}
		team.setEnrolmentsHashSet(enrollments);
	}

	/**
	 * Methode voor het verwijderen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void removeTeamMemberFromTeam(User teamMember, Team team) throws UserIsNotMemberOfTeamException {
		HashSet<Enrolment> enrollments = team.getEnrolmentsHashSet();
		if(enrollments.contains(teamMember)) {

			enrollments.forEach(e -> {
				if (e.getUser().equals(teamMember)) {
					e.setActive(false);
				}
			});
			team.setEnrolmentsHashSet(enrollments);
		}
		else{
			throw new UserIsNotMemberOfTeamException();

		}
	}
	
	/**
	 * Methode voor het maken van een teammanager
	 * USER MUST EXIST in the team
	 * 
	 * @param teammanager
	 */
	public void promoteTeamMemberToManagerInTeam(User teamMember, Team team) throws UserIsNotMemberOfTeamException {
		HashSet<Enrolment> enrollments = team.getEnrolmentsHashSet();
		if(team.getEnrolmentsHashSet().contains(teamMember)) {
			removeLeader(team);

			enrollments.forEach(e -> {
				if (e.getUser().equals(teamMember)) {
					e.setPrivilege(new TeamManagerPrivilege());
				}
			});
			team.setEnrolmentsHashSet(enrollments);
		}
		else{

			throw new UserIsNotMemberOfTeamException();

		}
	}

	private void removeLeader(Team team) {
		team.getEnrolmentsHashSet()
				.stream().filter(x -> x.getPrivilege() instanceof TeamManagerPrivilege && x.isActive())
				.forEach(x -> x.setActive(false));
		}





	/**
	 * Methode die de owner van de groep retourneert
	 * 
	 * @return User
	 */
	public User getOwnerOfTeam(Team team) {
		HashSet<Enrolment> enrollments = team.getEnrolmentsHashSet();
		User ownerReturn = null;
		for (Enrolment enrollment : enrollments) {
			if (enrollment.isActive() && enrollment.getPrivilege() instanceof TeamManagerPrivilege) {
				ownerReturn = enrollment.getUser();
			}
		}
		return ownerReturn;
	}
	
	public void addTeam(Team team) throws ValidationException {
		validator.validate(team);
		teamdb.save(team);
	}
	
	public Collection<Team> getAllTeams()
	{
		return teamdb.getAllElements();
	}

	public Team getTeam(User user) {
		return teamdb.findTeamOfUser(user);
	}
}
