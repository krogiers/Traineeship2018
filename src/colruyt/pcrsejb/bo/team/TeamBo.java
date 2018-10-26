package colruyt.pcrsejb.bo.team;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
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
	private HashSet<EnrolmentBo> enrollments;

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
		EnrolmentBo enrollment = new EnrolmentBo(teamManager, new TeamManagerPrivilegeBo(), true);
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
	 */
	public HashSet<EnrolmentBo> getEnrollments() {
		return enrollments;
	}
	
	/**
	 * Methode voor het zetten van de enrollments
	 * 
	 */
	public void setEnrollments(HashSet<EnrolmentBo> enrollments) {
		this.enrollments = enrollments;
	}	
}
