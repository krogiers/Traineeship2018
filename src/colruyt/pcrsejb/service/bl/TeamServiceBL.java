package colruyt.pcrsejb.service.bl;

import java.util.HashSet;

import colruyt.pcrsejb.entity.enrollment.Enrolment;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;

public class TeamServiceBL {
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
		Enrolment enrollment = null;
		HashSet<Enrolment> enrollments = team.getEnrollments();
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
		team.setEnrollments(enrollments);
	}

	/**
	 * Methode voor het verwijderen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void removeTeamMemberFromTeam(User teamMember, Team team) {
		HashSet<Enrolment> enrollments = team.getEnrollments();
		enrollments.forEach(e -> {
			if (e.getUser().equals(teamMember)) {
				e.setActive(false);
			}
		});
		team.setEnrollments(enrollments);
	}
	
	/**
	 * Methode voor het maken van een teammanager
	 * USER MUST EXIST in the team
	 * 
	 * @param teammanager
	 */
	public void promoteTeamMemberToManagerInTeam(User teamMember, Team team) {
		HashSet<Enrolment> enrollments = team.getEnrollments();
		enrollments.forEach(e -> {
			if (e.getUser().equals(teamMember)) {
				e.setPrivilege(new TeamManagerPrivilege());
			}
		});
		team.setEnrollments(enrollments);
	}

	/**
	 * Methode die de owner van de groep retourneert
	 * 
	 * @return User
	 */
	public User getOwnerOfTeam(Team team) {
		HashSet<Enrolment> enrollments = team.getEnrollments();
		User ownerReturn = null;
		for (Enrolment enrollment : enrollments) {
			if (enrollment.isActive() && enrollment.getPrivilege() instanceof TeamManagerPrivilege) {
				ownerReturn = enrollment.getUser();
			}
		}
		return ownerReturn;
	}
}
