package colruyt.pcrsejb.service.bl;

import java.util.Collection;
import java.util.HashSet;

import colruyt.pcrsejb.entity.enrollment.Enrollment;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.User.AbstractUserService;
import colruyt.pcrsejb.service.dl.User.MemoryUserService;
import colruyt.pcrsejb.service.dl.team.AbstractTeamService;
import colruyt.pcrsejb.service.dl.team.MemoryTeamService;

public class TeamServiceBL {
	
	private AbstractTeamService teamdb = new MemoryTeamService();
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
		addMemberToTeam(teamMember, team, new TeamManagerPrivilege());
	}
	
	private void addMemberToTeam(User teamMember, Team team, Privilege privilege) {
		Enrollment enrollment = null;
		HashSet<Enrollment> enrollments = team.getEnrolmentsHashSet();
		for (Enrollment en : enrollments) {
			if (en.getUser().equals(teamMember)) {
				enrollment = en;
				enrollment.setPrivilege(privilege);
				enrollment.setActive(true);
			}
		}
		if (enrollment == null) {
			enrollment = new Enrollment(teamMember, privilege, true);
			enrollments.add(enrollment);
		}
		team.setEnrolmentsHashSet(enrollments);
	}

	/**
	 * Methode voor het verwijderen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void removeTeamMemberFromTeam(User teamMember, Team team) {
		HashSet<Enrollment> enrollments = team.getEnrolmentsHashSet();
		enrollments.forEach(e -> {
			if (e.getUser().equals(teamMember)) {
				e.setActive(false);
			}
		});
		team.setEnrolmentsHashSet(enrollments);
	}
	
	/**
	 * Methode voor het maken van een teammanager
	 * USER MUST EXIST in the team
	 * 
	 * @param teammanager
	 */
	public void promoteTeamMemberToManagerInTeam(User teamMember, Team team) {
		HashSet<Enrollment> enrollments = team.getEnrolmentsHashSet();
		enrollments.forEach(e -> {
			if (e.getUser().equals(teamMember)) {
				e.setPrivilege(new TeamManagerPrivilege());
			}
		});
		team.setEnrolmentsHashSet(enrollments);
	}

	/**
	 * Methode die de owner van de groep retourneert
	 * 
	 * @return User
	 */
	public User getOwnerOfTeam(Team team) {
		HashSet<Enrollment> enrollments = team.getEnrolmentsHashSet();
		User ownerReturn = null;
		for (Enrollment enrollment : enrollments) {
			if (enrollment.isActive() && enrollment.getPrivilege() instanceof TeamManagerPrivilege) {
				ownerReturn = enrollment.getUser();
			}
		}
		return ownerReturn;
	}
	
	public void addTeam(Team team)
	{
		teamdb.addElement(team);
	}
	
	public Collection<Team> getAllTeams()
	{
		return teamdb.getAllElements();
	}
}
