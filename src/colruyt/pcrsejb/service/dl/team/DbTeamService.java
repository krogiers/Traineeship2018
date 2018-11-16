package colruyt.pcrsejb.service.dl.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.enrolment.DbEnrolmentService;
import colruyt.pcrsejb.service.dl.enrolment.EnrolmentService;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import colruyt.pcrsejb.service.dl.userPrivilege.DbUserPrivilegeService;
import colruyt.pcrsejb.service.dl.userPrivilege.UserPrivilegeService;

public class DbTeamService extends DbService implements TeamService {
	private EnrolmentService enrolmentService = new DbEnrolmentService();
	
	private static final String ADD_ELEMENT = "INSERT INTO TEAMS(ID, NAME) VALUES((SELECT MAX(ID) FROM TEAMS), ?)";
	private static final String GET_ELEMENT = "SELECT * FROM TEAMS WHERE ID=?";
	private static final String GET_ALL_ELEMENTS = "select * from teams";
	private static final String DELETE_ELEMENT = "DELETE FROM Teams WHERE ID = ? ";
	private static final String GET_TEAM_OF_USER = "SELECT * FROM Teamenrolments Join userprivileges up ON Userprivileges_ID = up.ID Join users on up.user_ID = users.ID inner join teams ts on team_id = ts.id where users.ID = ?";
    private static final String GET_TEAM_OF_ENROLMENT = "SELECT * FROM TEAMENROLMENTS where id = ?";
	private UserPrivilegeService userPrivilegeService = new DbUserPrivilegeService();

    @Override
    public Team save(Team element) {
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(ADD_ELEMENT);
            preparedStatement.setString(1, element.getName());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getResultSet();
            if (rs.next()) {
                element.setTeamID(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public Team getElement(Team team) {
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
            preparedStatement.setInt(1, team.getTeamID());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                team = new Team();
                team.setTeamID(rs.getInt("ID"));
                team.setName(rs.getString("Name"));
                team.setEnrolmentsHashSet(enrolmentService.getEnrolmentsForTeam(team));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public Collection<Team> getAllElements() {
        List<Team> teamList = new ArrayList<>();
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_ELEMENTS);
            ResultSet rs = preparedStatement.executeQuery();
            Team team;
            while (rs.next()) {
                team = new Team();
                team.setTeamID(rs.getInt("ID"));
                team.setName(rs.getString("Name"));
                team.setEnrolmentsHashSet(enrolmentService.getEnrolmentsForTeam(team));
                teamList.add(team);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return teamList;
    }

    @Override
    public void deleteElement(Team element) {
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ELEMENT);
            preparedStatement.setInt(1, element.getTeamID());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }

    @Override
    public Team findTeamOfUser(User user) {
        Team team = null;
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_TEAM_OF_USER);
            preparedStatement.setInt(1, user.getId());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                team = new Team();
                team.setTeamID(rs.getInt("ID"));
                team.setName(rs.getString("Name"));
                team.setEnrolmentsHashSet(enrolmentService.getEnrolmentsForTeam(team));
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return team;
    }

    @Override
    public Team findTeamOfEnrolments(Enrolment e) {
        Team team = null;
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_TEAM_OF_ENROLMENT);
            preparedStatement.setInt(1, e.getEnrolmentID());
            ResultSet rs = preparedStatement.executeQuery();
            while (rs.next()) {
                team = new Team();
                team.setTeamID(rs.getInt("TEAM_ID"));
                team = getElement(team);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return team;
    }
}
