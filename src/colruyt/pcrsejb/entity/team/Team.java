package colruyt.pcrsejb.entity.team;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privileges.Privilege;
import colruyt.pcrsejb.entity.user.privileges.TeamManagerPrivilege;

import java.util.Map;

public class Team {

	private String name;
	private Map<User, Privilege> teamMembersMap;

	/**
	 * Constructor voor het aanmaken van een Team
	 * @param name
	 * @param teamMembersMap
	 */
	public Team(String name, Map<User, Privilege> teamMembersMap) {
		setName(name);
		setTeamMembersMap(teamMembersMap);
	}

	/**
	 * Methode die de naam van het team retourneert
	 * @return naam van het team
	 */
	public String getName() {
		return name;
	}

	/**
	 * Methode voor het instellen van de teamnaam
	 * 
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Methode die alle teammembers retourneert
	 * 
	 * @return teamMembersMap
	 */
	public Map<User, Privilege> getTeamMembersMap() {
		return teamMembersMap;
	}

	/**
	 * Methode die een map van users met bepaalde privileges gaat toevoegen
	 * 
	 * @param teamMembersMap
	 */
	public void setTeamMembersMap(Map<User, Privilege> teamMembersMap) {
		this.teamMembersMap = teamMembersMap;
	}

	/**
	 * Methode die de owner van de groep retourneert
	 * 
	 * @return User
	 */
	public String getOwner() {
		User ownerReturn = null;
		for (Map.Entry<User, Privilege> owner : teamMembersMap.entrySet()) {
			if (owner.getValue() instanceof TeamManagerPrivilege) {
				ownerReturn = owner.getKey();
			}
		}
		return ownerReturn.toString();
	}

}
