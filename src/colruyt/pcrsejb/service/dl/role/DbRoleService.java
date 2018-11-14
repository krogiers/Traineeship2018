package colruyt.pcrsejb.service.dl.role;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.dl.DbService;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DbRoleService  extends DbService implements RoleService {

	private static final String GET_ELEMENT = "SELECT * FROM Roles where id = ?";
	private static final String GET_ALL_ELEMENTS = "SELECT * from Roles";
	private static final String DELETE_ELEMENT = "DELETE FROM Roles WHERE ID = ?";
	private static final String ADD_ROLE = "INSERT INTO ROLES(ID, Name) VALUES((SELECT MAX(ID) FROM FUNCTIONS)+1, ?)";
	private static final String UPDATE_ROLE = "INSERT into roles (id,name) values (((select max(id) from FUNCTIONS)+1), ?)";
	private static final String GET_ALL_ROLES_FOR_FUNCTION = "select * from functionroles where functions_id = ?";

	@Override
	public Role save(Role element) {
		try(Connection conn = this.createConnection()) {
			PreparedStatement statement;

			if(element.getId() != null){
				statement = conn.prepareStatement(UPDATE_ROLE, new String[] {"ID"});
			}
			else{
				statement = conn.prepareStatement(ADD_ROLE, new String[] {"ID"});
			}
			statement.setString(1, element.getName());
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				element.setId(rs.getInt("ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public Role getElement(Role element) {
		try (Connection conn = this.createConnection()){
			PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
			preparedStatement.setInt(1, element.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while(rs.next()){
				element = new Role();
				element.setId(rs.getInt("ID"));
				element.setName(rs.getString("NAME"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return element;
	}

	@Override
	public Collection<Role> getAllElements() {
		List<Role> roleList = new ArrayList<>();
		try (Connection conn = this.createConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_ELEMENTS);
			ResultSet rs = preparedStatement.executeQuery();
			roleList = convertToRoleList(rs);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleList;
	}

	@Override
	public void deleteElement(Role element) {
		try (Connection conn = this.createConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(DELETE_ELEMENT);
			preparedStatement.setInt(1, element.getId());
			ResultSet rs = preparedStatement.executeQuery();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public HashSet<Role> getAllRolesForFunction(Function function) {
		HashSet<Role> roleList = new HashSet<>();
		try (Connection conn = this.createConnection()) {
			PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_ROLES_FOR_FUNCTION);
			preparedStatement.setInt(1,function.getId());
			ResultSet rs = preparedStatement.executeQuery();
			while (rs.next()) {
				Role role = new Role();
				role.setId(rs.getInt("ROLES_ID"));
				role = getElement(role);
				roleList.add(role);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return roleList;
	}


	private List<Role> convertToRoleList(ResultSet rs) throws SQLException {
		List<Role> roleList = new ArrayList<>();
		while(rs.next()){
			Role role = new Role();
			role.setId(rs.getInt("ID"));
			role.setName(rs.getString("Name"));
			roleList.add(role);
		}
		return roleList;
	}
}
