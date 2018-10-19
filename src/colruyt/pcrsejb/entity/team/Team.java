package colruyt.pcrsejb.entity.team;

import java.util.HashMap;
import java.util.Map;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privileges.Privilege;
import colruyt.pcrsejb.entity.user.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.user.privileges.TeamMemberPrivilege;

/**
 * Klasse voor het aanmaken van een Team.
 * 
 * @author jda1mbw
 */
public class Team {

	private String name;
	private HashMap<User, Privilege> teamMembersMap;

	/**
	 * Constructor voor het aanmaken van een Team
	 * 
	 * @param name
	 * @param teamManager
	 */
	public Team(String name, User teamManager) {
		setName(name);
		teamMembersMap = new HashMap<>();
		teamMembersMap.put(teamManager, checkLeader(teamManager));
	}

	/**
	 * Methode die controleert ofdat de User wel 
	 * het privilege TeamManager heeft
	 * @param teamManager
	 * @return privilege
	 */
	public Privilege checkLeader(User teamManager) {
		if (teamManager.getPrivileges().contains(new TeamManagerPrivilege())) {
			for (Privilege privi : teamManager.getPrivileges()) {
				if (privi instanceof TeamManagerPrivilege) {
					return privi;
				}

			}

		}
		throw new IllegalAccessError("User heeft niet de juiste privileges");
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
	public void setTeamMembersMap(HashMap<User, Privilege> teamMembersMap) {
		this.teamMembersMap = teamMembersMap;
	}

	/**
	 * Methode voor het toevoegen van een teamMember
	 * 
	 * @param teamMember
	 */
	public void addTeamMember(User teamMember) {
		teamMembersMap.put(teamMember, new TeamMemberPrivilege());
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
