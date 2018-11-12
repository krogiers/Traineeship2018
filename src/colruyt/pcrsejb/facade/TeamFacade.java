package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.team.TeamBoConverter;
import colruyt.pcrsejb.converter.team.TeamConverter;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.service.bl.TeamServiceBL;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;

import java.util.ArrayList;

public class TeamFacade {
	private TeamServiceBL teamServiceBL = new TeamServiceBL();
	private TeamBoConverter teamBoConverter = new TeamBoConverter();
	private TeamConverter teamConverter = new TeamConverter();
	private UserBoConverter userBoConverter = new UserBoConverter();
	private UserConverter userConverter = new UserConverter();
	
	public void addTeam(TeamBo newTeam) 
	{
		Team team = teamBoConverter.convertTo(newTeam);
		try {
			teamServiceBL.addTeam(team);
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void removeTeam(TeamBo oldTeam)
	{
		Team team = teamBoConverter.convertTo(oldTeam);
		teamServiceBL.removeTeam(team);
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

	public UserBo getManager(TeamBo team) {
//		Team t = teamBoConverter.convertTo(team);
//		User manager = teamServiceBL.getOwnerOfTeam(t);
//		UserBo returning = userConverter.convertTo(manager);
//		return returning;
		return userConverter.convertTo(teamServiceBL.getOwnerOfTeam(teamBoConverter.convertTo(team)));
	}

	public TeamBo getTeam(UserBo user) {
//		User usertje = userBoConverter.convertTo(user);
//		Team returning = teamServiceBL.getTeam(usertje);
//		TeamBo returningBo = teamConverter.convertTo(returning);
//		return returningBo;
		return teamConverter.convertTo(teamServiceBL.getTeam(userBoConverter.convertTo(user)));
	}
	
}
