
package colruyt.pcrsejb.entity.team;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.user.User;

import java.util.HashSet;

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
		Enrolment enrollment = new Enrolment(teamManager, new TeamManagerPrivilege(), true);
		enrolmentsHashSet = new HashSet<>();
		enrolmentsHashSet.add(enrollment);
	}

	public Team(int teamID, String name, HashSet<Enrolment> enrolmentsHashSet) {
		this.teamID = teamID;
		this.name = name;
		this.enrolmentsHashSet = enrolmentsHashSet;
	}

	/**
	 * Methode die het teamID retourneert
	 * @return teamID
	 */
	public int getTeamID() {
		return teamID;
	}

	/**
	 * Methode voor het instellen van het teamID
	 * @param teamID
	 */
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

}
