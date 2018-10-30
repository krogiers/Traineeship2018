package colruyt.pcrsejb.bo.user;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Klasse voor het aanmaken van een User.
 * 
 * @author jda1mbw
 */
public class UserBo {

	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private HashSet<PrivilegeBo> privilegeBoHashSet;

	/**
	 * Constructor voor het aanmaken van een User
	 *
	 * @param firstName String
	 * @param lastName String
	 * @param email String
	 * @param password String
	 * @param privilegeBoHashSet HashSet
	 */
	public UserBo(String firstName, String lastName, String email, String password, HashSet<PrivilegeBo> privilegeBoHashSet) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setPrivilegeBoHashSet(privilegeBoHashSet);
	}

	public UserBo() {
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
	public Set<PrivilegeBo> getPrivilegeBoHashSet() {
		return privilegeBoHashSet;
	}

	/**
	 * Methode voor het instellen van 1 of meer privileges
	 * 
	 * @param privilegeBoHashSet
	 */
	public void setPrivilegeBoHashSet(HashSet<PrivilegeBo> privilegeBoHashSet) {
		this.privilegeBoHashSet = privilegeBoHashSet;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", privileges="
				+ privilegeBoHashSet + "]";
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		UserBo user = (UserBo) o;
		return Objects.equals(email, user.email);
	}

	@Override
	public int hashCode() {
		return Objects.hash(email);
	}
}