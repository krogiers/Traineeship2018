package colruyt.pcrsejb.facade;

import java.util.ArrayList;

import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.team.TeamBoConverter;
import colruyt.pcrsejb.converter.team.TeamConverter;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.TeamServiceBL;

public class TeamFacade {
	private TeamServiceBL teamServiceBL = new TeamServiceBL();
	private TeamBoConverter teamBoConverter = new TeamBoConverter();
	private TeamConverter teamConverter = new TeamConverter();
	
	public void addTeam(TeamBo newTeam)
	{
		Team team = teamBoConverter.convertTo(newTeam);
		teamServiceBL.addTeam(team);
	}
	
	public void removeTeam(TeamBo team)
	{
		//TO DO
	}
	
	public ArrayList<TeamBo> getAllTeams()
	{
		ArrayList<TeamBo> teams = new ArrayList<>();
		for(Team t: teamServiceBL.getAllTeams())
		{
			teams.add(teamConverter.convertTo(t));
		}
		return teams;
	}

	public void removeUserFromTeam(TeamBo team, UserBo user) {
		// TODO		
	}

	public void addUserToTeam(TeamBo team, UserBo user) {
		// TODO 
	}
	
}
