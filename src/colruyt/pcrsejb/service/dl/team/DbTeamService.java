package colruyt.pcrsejb.service.dl.team;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import colruyt.pcrsejb.service.dl.userPrivilege.DbUserPrivilegeService;
import colruyt.pcrsejb.service.dl.userPrivilege.UserPrivilegeService;

public class DbTeamService extends DbService implements TeamService {
	private UserService userService = new DbUserService();
	private UserPrivilegeService userPrivilegeService = new DbUserPrivilegeService();
	
	private static final String ADD_ELEMENT = "INSERT INTO TEAMS(ID, NAME) VALUES((SELECT MAX(ID) FROM TEAMS), ?)";
	private static final String GET_ELEMENT = "SELECT * FROM TEAMS WHERE ID=?";
	private static final String GET_ALL_ELEMENTS = "select * from teams t left join teamenrolments e on T.ID = E.TEAM_ID left join userprivileges up on e.userprivileges_id = Up.ID";
	private static final String DELETE_ELEMENT = "DELETE FROM Teams WHERE ID = ? ";
	private static final String GET_TEAM_OF_USER = "SELECT * FROM Teamenrolments Join userprivileges up ON Userprivileges_ID = up.ID Join users on up.user_ID = users.ID where users.ID = ?";

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
			Team team = new Team();
			while (rs.next()) {
				if (team.getTeamID() != rs.getInt("ID")) {
					team = new Team();
					team.setTeamID(rs.getInt("ID"));
					team.setName(rs.getString("Name"));
					team.setEnrolmentsHashSet(new HashSet<>());
				}
				rs.getInt("Userprivileges_id");
				if(!(rs.wasNull())) {
					HashSet<Enrolment> enrolments = team.getEnrolmentsHashSet();
					//
					Enrolment enrolment = new Enrolment();
					enrolment.setActive(rs.getBoolean("Active"));
					enrolment.setEnrolmentID(rs.getInt("Id_1"));
					enrolment.setPrivilege(userPrivilegeService.getElement(new UserPrivilege(rs.getInt("Userprivileges_id"))));
					enrolment.setUser(userService.getElement(new User(rs.getInt("User_id"))));
					
					
					enrolments.add(enrolment);
					team.setEnrolmentsHashSet(enrolments);
					
				}
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
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return team;
	}
}
