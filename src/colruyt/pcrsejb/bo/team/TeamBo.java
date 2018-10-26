package colruyt.pcrsejb.bo.team;

import colruyt.pcrsejb.bo.enrollment.EnrollmentBo;
import colruyt.pcrsejb.bo.privileges.TeamManagerPrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;

import java.util.HashSet;

/**
 * Klasse voor het aanmaken van een Team.
 * 
 * @author jda1mbw
 */
public class TeamBo {

	private String name;
	private HashSet<EnrollmentBo> enrollments;

	public TeamBo() 
	{
	};
	/**
	 * Constructor voor het aanmaken van een Team
	 *
	 * @param name
	 * @param teamManager
	 */
	public TeamBo(String name, UserBo teamManager) {
		setName(name);
		EnrollmentBo enrollment = new EnrollmentBo(teamManager, new TeamManagerPrivilegeBo(), true);
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
	public HashSet<EnrollmentBo> getEnrollments() {
		return enrollments;
	}
	
	/**
	 * Methode voor het zetten van de enrollments
	 * 
	 * @param teamMember
	 */
	public void setEnrollments(HashSet<EnrollmentBo> enrollments) {
		this.enrollments = enrollments;
	}	
}
