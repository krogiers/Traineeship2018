package colruyt.pcrsejb.service.dl.team;

import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DbTeamService extends DbService implements TeamService {
    private static final String ADD_ELEMENT = "INSERT INTO TEAMS(ID, NAME) VALUES((SELECT MAX(ID) FROM TEAMS), ?)";
    private static final String GET_ELEMENT = "SELECT * FROM TEAMS WHERE ID=?";
    private static final String GET_ALL_ELEMENTS = "SELECT * FROM Teams";
    private static final String DELETE_ELEMENT = "DELETE FROM Teams WHERE ID = ? ";

    @Override
    public Team addElement(Team element) {
        try(Connection conn = this.createConnection()) {
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
    public Team getElement(Long index) {
        Team team = null;
        try (Connection conn = this.createConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
            preparedStatement.setInt(1, index.intValue());
            ResultSet rs = preparedStatement.executeQuery();
            while(rs.next()){
                team = new Team();
                team.setTeamID(rs.getInt("ID"));
                team.setName(rs.getString("Name"));
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
            while(rs.next()){
                Team team = new Team();
                team.setTeamID(rs.getInt("ID"));
                team.setName(rs.getString("Name"));
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
            preparedStatement.setInt(1, (int) element.getTeamID());
            ResultSet rs = preparedStatement.executeQuery();
        } catch (SQLException e1) {
            e1.printStackTrace();
        }
    }
}
