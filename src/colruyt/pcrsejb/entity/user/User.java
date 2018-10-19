package colruyt.pcrsejb.entity.user;

import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.privileges.Privilege;
import java.util.HashSet;
import java.util.Set;

/**
 * Klasse voor het aanmaken van een User.
 * 
 * @author jda1mbw
 */
public class User {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private HashSet<Privilege> privileges;
	private Team team;

	/**
	 * Constructor voor het aanmaken van een User
	 * 
	 * @param firstName
	 * @param lastName
	 * @param email
	 * @param password
	 * @param privileges
	 */
	public User(String firstName, String lastName, String email, String password, HashSet<Privilege> privileges) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setPrivileges(privileges);
	}

	/**
	 * Methode voor het opvragen van de voornaam
	 * 
	 * @return firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Methode voor het instellen van de voornaam
	 * 
	 * @param firstName
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Methode voor het opvragen van de familienaam
	 * 
	 * @return lastName
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Methode voor het instellen van de familienaam
	 * 
	 * @param lastName
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Methode voor het opvragen van het e-mailadres
	 * 
	 * @return email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Methode voor het instellen van het e-mailadres
	 * 
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * Methode voor opvragen van het paswoord
	 * 
	 * @return password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Methode voor het instellen van het paswoord
	 * 
	 * @param password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Methode voor het opvragen van alle privileges van de gebruiker
	 * 
	 * @return privileges
	 */
	public Set<Privilege> getPrivileges() {
		return privileges;
	}

	/**
	 * Methode voor het instellen van 1 of meer privileges
	 * 
	 * @param privileges
	 */
	public void setPrivileges(HashSet<Privilege> privileges) {
		this.privileges = privileges;
	}

	/**
	 * Methode voor het opvragen van het huidige team
	 * 
	 * @return team
	 */
	public Team getTeam() {
		return team;
	}

	/**
	 * Methode voor het instellen van het team
	 * 
	 * @param team
	 */
	public void setTeam(Team team) {
		this.team = team;
	}
	
	/**
	 * Methode voor het aanvragen van privilege
	 * 
	 * @return privilegeReturn
	 */
	public Privilege hasPrivilege(Privilege privilege) {
		Privilege privilegeReturn = null;
		for (Privilege privi : this.getPrivileges()) {
			if (privilege.getClass().isInstance(privi)) {
				privilegeReturn = privi;
			}
		}
		return privilegeReturn;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", privileges="
				+ privileges + ", team=" + team + "]";
	}

}