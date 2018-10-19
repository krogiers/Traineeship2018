package colruyt.pcrsejb.service.bl;

import java.util.HashSet;

import colruyt.pcrsejb.entity.enrollment.Enrollment;
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
		Enrollment enrollment = null;
		HashSet<Enrollment> enrollments = team.getEnrollments();
		for (Enrollment en : enrollments) {
			if (en.getUser().equals(teamMember)) {
				enrollment = en;
				enrollment.setActive(true);
			}
		}
		if (enrollment == null) {
			enrollment = new Enrollment(teamMember, new TeamMemberPrivilege(), true);
			enrollments.add(enrollment);
		}
		team.setEnrollments(enrollments);
	}
//
//	/**
//	 * Methode voor het verwijderen van een teamMember
//	 * 
//	 * @param teamMember
//	 */
//	public void removeTeamMember(User teamMember) {
//		enrollments.forEach(e -> {
//			if (e.getUser().equals(teamMember)) {
//				e.setActive(false);
//			}
//		});
//	}
//	
//	/**
//	 * Methode voor het maken van een teammanager
//	 * USER MUST EXIST in the team
//	 * 
//	 * @param teammanager
//	 */
//	public void promoteToManager(User teamMember) {
//		enrollments.forEach(e -> {
//			if (e.getUser().equals(teamMember)) {
//				e.setPrivilege(new TeamManagerPrivilege());
//			}
//		});
//	}
//	
//	/**
//	 * Methode voor het maken van een teammanager
//	 * USER MUST EXIST in the team
//	 * 
//	 * @param teammanager
//	 */
//	public void addManager(User teamMember) {
//		Enrollment enrollment = null;
//		for (Enrollment en : enrollments) {
//			if (en.getUser().equals(teamMember)) {
//				enrollment = en;
//				enrollment.setActive(true);
//			}
//		}
//		if (enrollment == null) {
//			enrollment = new Enrollment(teamMember, new TeamMemberPrivilege(), true);
//			enrollments.add(enrollment);
//		}
//	}
//
//	/**
//	 * Methode die de owner van de groep retourneert
//	 * 
//	 * @return User
//	 */
//	public User getOwner() {
//		User ownerReturn = null;
//		for (Enrollment enrollment : enrollments) {
//			if (enrollment.isActive() && enrollment.getPrivilege() instanceof TeamManagerPrivilege) {
//				ownerReturn = enrollment.getUser();
//			}
//		}
//		return ownerReturn;
//	}
}
