package colruyt.pcrsejb.bo.user;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * Klasse voor het aanmaken van een User.
 * 
 * @author jda1mbw
 */
public class UserBo {

	private int id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private HashSet<UserPrivilegeBo> privilegeBoHashSet;
	private String country;


	/**
	 * Constructor voor het aanmaken van een User
	 *
	 * @param firstName String
	 * @param lastName String
	 * @param email String
	 * @param password String
	 * @param privilegeBoHashSet HashSet
	 */
	public UserBo(int id,String firstName, String lastName, String email, String password, HashSet<UserPrivilegeBo> privilegeBoHashSet,
				  String country) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setId(id);
		setPrivilegeBoHashSet(privilegeBoHashSet);
		setCountry(country);
	}
	
	public UserBo(String firstName, String lastName, String email, String password, HashSet<UserPrivilegeBo> privilegeBoHashSet,
				  String country) {
		setFirstName(firstName);
		setLastName(lastName);
		setEmail(email);
		setPassword(password);
		setPrivilegeBoHashSet(privilegeBoHashSet);
		setCountry(country);
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UserBo() {
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
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
	public Set<UserPrivilegeBo> getPrivilegeBoHashSet() {
		return privilegeBoHashSet;
	}

	/**
	 * Methode voor het instellen van 1 of meer privileges
	 * 
	 * @param privilegeBoHashSet
	 */
	public void setPrivilegeBoHashSet(HashSet<UserPrivilegeBo> privilegeBoHashSet) {
		this.privilegeBoHashSet = privilegeBoHashSet;
	}

	@Override
	public String toString() {
		return "User [firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", privileges="
				+ privilegeBoHashSet + " country=" + country + "]";
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