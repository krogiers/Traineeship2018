package colruyt.pcrsejb.entity.team;

import java.util.HashSet;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

/**
 * Klasse voor het aanmaken van een Team.
 * 
 * @author jda1mbw
 */
public class Team {

	private int teamID;
	private String name;
	private HashSet<Enrolment> enrolmentsHashSet;

	public Team() {};
	/**
	 * Constructor voor het aanmaken van een Team
	 * 
	 * @param name
	 * @param teamManager
	 */
	public Team(String name, User teamManager) {
		setName(name);
		UserPrivilege privilege = null;
		for (UserPrivilege priv : teamManager.getPrivileges()) {
			if (priv.getPrivilegeType() == PrivilegeType.TEAMMANAGER) {
				privilege = priv;
			}
		}
		if (privilege == null) {
			privilege = new UserPrivilege(PrivilegeType.TEAMMANAGER, true);
			HashSet<UserPrivilege> privileges = teamManager.getPrivileges();
			privileges.add(privilege);
			teamManager.setPrivileges(privileges);
		}
		Enrolment enrollment = new Enrolment(teamManager, privilege, true);
		enrolmentsHashSet = new HashSet<>();
		enrolmentsHashSet.add(enrollment);
	}

	public Team(int teamID, String name, HashSet<Enrolment> enrolmentsHashSet) {
		this.teamID = teamID;
		this.name = name;
		this.enrolmentsHashSet = enrolmentsHashSet;
	}

	public int getTeamID() {
		return teamID;
	}

	public void setTeamID(int teamID) {
		this.teamID = teamID;
	}

	/**
	 * Methode die de naam van het team retourneert
	 * 
	 * @return name van het team
	 */
	public String getName() {
		return name;
	}

	/**
	 * Methode voor het instellen van de teamnaam
	 * 
	 * @param name van het team
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Methode voor terugkrijgen van de Enrollments
	 *
	 */
	public HashSet<Enrolment> getEnrolmentsHashSet() {
		return enrolmentsHashSet;
	}

	/**
	 * Methode voor het zetten van de enrollments
	 *
	 * @param enrollments
	 */
	public void setEnrolmentsHashSet(HashSet<Enrolment> enrollments) {
		this.enrolmentsHashSet = enrollments;
	}
	public boolean contains(User teamMember) {
		boolean contains = false;
		for (Enrolment e : getEnrolmentsHashSet()) {
			if (e.getUser() == teamMember) {
				contains = true;
			}
		}
		return contains;
	}

}
