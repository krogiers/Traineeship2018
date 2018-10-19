package colruyt.pcrsejb.entity.team;

import colruyt.pcrsejb.entity.user.*;
import colruyt.pcrsejb.entity.user.privileges.*;

import java.util.*;

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
		teamMembersMap.put(teamManager, teamManager.hasPrivilege(new TeamManagerPrivilege()));
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
	
	
	@Override
	public boolean equals(Object o){
		if(this == o)
			return true;
		if(!(o instanceof Team))
			return false;
		Team team = (Team) o;
		return Objects.equals(getName(), team.getName()) && Objects.equals(getTeamMembersMap(), team.getTeamMembersMap());
	}
	
	@Override
	public int hashCode(){
		return Objects.hash(getName(), getTeamMembersMap());
	}
	
	@Override
	public String toString(){
		return "Team{" + "name='" + name + '\'' + ", teamMembersMap=" + teamMembersMap + '}';
	}
}
