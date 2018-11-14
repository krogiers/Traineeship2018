package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.team.TeamBoConverter;
import colruyt.pcrsejb.converter.team.TeamConverter;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.TeamServiceBL;
import colruyt.pcrsejb.util.exceptions.bl.UserIsNotMemberOfTeamException;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class TeamFacade {
    private TeamServiceBL teamServiceBL = new TeamServiceBL();
    private TeamBoConverter teamBoConverter = new TeamBoConverter();
    private TeamConverter teamConverter = new TeamConverter();
    private UserBoConverter userBoConverter = new UserBoConverter();
    private UserConverter userConverter = new UserConverter();

    public void addTeam(TeamBo newTeam) {
        Team team = teamBoConverter.convertTo(newTeam);
        try {
            teamServiceBL.addTeam(team);
        } catch (ValidationException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void removeTeam(TeamBo oldTeam) {
        Team team = teamBoConverter.convertTo(oldTeam);
        teamServiceBL.removeTeam(team);
    }

    public ArrayList<TeamBo> getAllTeams() {
        ArrayList<TeamBo> teams = new ArrayList<>();
        for (Team t : teamServiceBL.getAllTeams()) {
            teams.add(teamConverter.convertTo(t));
        }
        return teams;
    }

    public void removeUserFromTeam(TeamBo team, UserBo user) {
        try {
            this.teamServiceBL.removeTeamMemberFromTeam(this.userBoConverter.convertTo(user), this.teamBoConverter.convertTo(team));
        } catch (UserIsNotMemberOfTeamException e) {
            e.printStackTrace();
        }
    }

    public void addUserToTeam(TeamBo team, UserBo user) {
        //TOdo
    }

    public UserBo getManager(TeamBo team) {
//		Team t = teamBoConverter.convertTo(team);
//		user manager = teamServiceBL.getOwnerOfTeam(t);
//		UserBo returning = userConverter.convertTo(manager);
//		return returning;
        return userConverter.convertTo(teamServiceBL.getOwnerOfTeam(teamBoConverter.convertTo(team)));
    }

    public UserBo getManager(UserBo userbo) {

        //Get the current Team of the UserBo
        Team currentTeam = teamServiceBL.getTeam(this.userBoConverter.convertTo(userbo));

        //Return the Owner of the Team
        return this.userConverter.convertTo(this.teamServiceBL.getOwnerOfTeam(currentTeam));
    }

    public TeamBo getTeam(UserBo user) {
//		user usertje = userBoConverter.convertTo(user);
//		Team returning = teamServiceBL.getTeam(usertje);
//		TeamBo returningBo = teamConverter.convertTo(returning);
//		return returningBo;
        return teamConverter.convertTo(teamServiceBL.getTeam(userBoConverter.convertTo(user)));
    }

    public List<TeamBo> getTeamsOfManager(UserBo manager) {
        List<TeamBo> teams = new ArrayList<>();
        for(Team t : teamServiceBL.getTeamsOfManager(userBoConverter.convertTo(manager))){
            teams.add(teamConverter.convertTo(t));
        }
        return teams;
    }
}
