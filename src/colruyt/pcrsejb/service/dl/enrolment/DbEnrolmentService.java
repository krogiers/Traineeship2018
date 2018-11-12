package colruyt.pcrsejb.service.dl.enrolment;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashSet;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import colruyt.pcrsejb.service.dl.userPrivilege.DbUserPrivilegeService;
import colruyt.pcrsejb.service.dl.userPrivilege.UserPrivilegeService;

public class DbEnrolmentService extends DbService implements EnrolmentService {
	private UserService userService = new DbUserService();
	private UserPrivilegeService userPrivilegeService = new DbUserPrivilegeService();
	
	private static final String GET_ENROLMENTS_FROM_TEAM = "Select * from teamenrolments where team_id = ?";

	@Override
	public Enrolment save(Enrolment element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Enrolment getElement(Enrolment element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Enrolment> getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteElement(Enrolment element) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public HashSet<Enrolment> getEnrolmentsForTeam(Team team) {
		HashSet<Enrolment> enrolments = new HashSet<>();
		try (Connection conn = this.createConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(GET_ENROLMENTS_FROM_TEAM);
			preparedStatement.setInt(1, team.getTeamID());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Enrolment enrolment = new Enrolment();
				enrolment.setActive("1".equalsIgnoreCase(rs.getString("ACTIVE")));
				enrolment.setEnrolmentID(rs.getInt("Id"));
				enrolment.setPrivilege(userPrivilegeService.getElement(new UserPrivilege(rs.getInt("Userprivileges_id"))));
				enrolment.setUser(userPrivilegeService.getUserfromUserPrivileges(enrolment.getPrivilege()));
				enrolments.add(enrolment);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return enrolments;
	}
}