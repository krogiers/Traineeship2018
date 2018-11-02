package colruyt.pcrsejb.service.bl;

import java.util.Collection;
import java.util.HashSet;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;
import colruyt.pcrsejb.service.dl.team.MemoryTeamService;
import colruyt.pcrsejb.service.dl.team.TeamService;
import colruyt.pcrsejb.util.exceptions.bl.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.validators.team.TeamValidator;

public class TeamServiceBL {
	
	private TeamService teamdb = new MemoryTeamService();
	private FunctionService functiondb = new DbFunctionService();
	private TeamValidator validator = new TeamValidator();
	/**
	 * Methode voor het toevoegen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void addTeamMemberToTeam(User teamMember, Function function, Team team) {
		FunctionUserPrivilege privilege = new FunctionUserPrivilege(PrivilegeType.TEAMMEMBER, true, function);
		HashSet<UserPrivilege> privileges = teamMember.getPrivileges();
		privileges.add(privilege);
		teamMember.setPrivileges(privileges);
		addMemberToTeam(teamMember, team, privilege);
	}
	
	/**
	 * Methode voor het maken van een teammanager
	 * 
	 * @param teammanager
	 */
	public void addManagerToTeam(User teamMember, Team team) {
		//TODO CHECK IF CURRENT MANAGER NOT EXISTING in team or in users privileges
		this.removeLeader(team);
		UserPrivilege privilege = new UserPrivilege(PrivilegeType.TEAMMANAGER, true);
		HashSet<UserPrivilege> privileges = teamMember.getPrivileges();
		privileges.add(privilege);
		teamMember.setPrivileges(privileges);
		addMemberToTeam(teamMember, team, privilege);
	}
	
	private void addMemberToTeam(User teamMember, Team team, UserPrivilege privilege) {
		Enrolment enrollment = null;
		HashSet<Enrolment> enrollments = team.getEnrolmentsHashSet();
		for (Enrolment en : enrollments) {
			if (en.getUser().equals(teamMember) && en.getPrivilege() == privilege) {
				enrollment = en;
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
		if(team.contains(teamMember)) {
			HashSet<Enrolment> enrolments = team.getEnrolmentsHashSet();
			enrolments.forEach(e -> {
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
	 * @throws UserIsNotMemberOfTeamException 
	 */
	public void promoteTeamMemberToManagerInTeam(User teamMember, Team team) throws UserIsNotMemberOfTeamException {
		HashSet<Enrolment> enrolments = team.getEnrolmentsHashSet();
		if(team.contains(teamMember)) {
			removeLeader(team);

			enrolments.forEach(enrolment -> {
				if (enrolment.getUser().equals(teamMember)) {
				enrolment.setActive(false);
				addManagerToTeam(teamMember, team);
			}
			});
			team.setEnrolmentsHashSet(enrolments);
		}
		else{

			throw new UserIsNotMemberOfTeamException();

		}
	}

	private void removeLeader(Team team) {
		team.getEnrolmentsHashSet()
				.stream().filter(x -> x.getPrivilege().getPrivilegeType() == PrivilegeType.TEAMMANAGER && x.isActive())
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
			if (enrollment.isActive() && enrollment.getPrivilege().getPrivilegeType() == PrivilegeType.TEAMMANAGER) {
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

	public void removeTeam(Team team) {
		teamdb.deleteElement(team);
	}
}
