package colruyt.pcrsejb.entity.team;

import java.util.HashSet;
import colruyt.pcrsejb.entity.enrollment.Enrollment;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.user.User;

/**
 * Klasse voor het aanmaken van een Team.
 * 
 * @author jda1mbw
 */
public class Team {

	private String name;
	private HashSet<Enrollment> enrollments;

	public Team() {};
	/**
	 * Constructor voor het aanmaken van een Team
	 * 
	 * @param name
	 * @param teamManager
	 */
	public Team(String name, User teamManager) {
		setName(name);
		Enrollment enrollment = new Enrollment(teamManager, new TeamManagerPrivilege(), true);
		enrollments = new HashSet<>();
		enrollments.add(enrollment);
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
	 * @param teamMember
	 */
	public HashSet<Enrollment> getEnrollments() {
		return enrollments;
	}
	
	/**
	 * Methode voor het zetten van de enrollments
	 * 
	 * @param teamMember
	 */
	public void setEnrollments(HashSet<Enrollment> enrollments) {
		this.enrollments = enrollments;
	}

}
