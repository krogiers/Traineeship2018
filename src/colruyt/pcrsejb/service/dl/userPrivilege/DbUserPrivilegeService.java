package colruyt.pcrsejb.service.dl.userPrivilege;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.LocalDate;
import java.util.Collection;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.FunctionUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;

public class DbUserPrivilegeService extends DbService implements UserPrivilegeService {
	private FunctionService fs = new DbFunctionService();
	private UserService us = new DbUserService();

	
	
	
	private static final String INSERT_USERPRIVILEGE= "INSERT INTO userprivileges(id, user_id, functions_id, active, country, privis_id) values (((select max(id) from userprivileges)+1), ?, ?, ?, ?, ?) ";
	private static final String UPDATE_ACTIVE_FROM_USERPRIVILEGE= "UPDATE userprivileges set active = ? where id = ?";
	private static final String UPDATE_USERPRIVILEGE = "UPDATE userprivileges set user_id = ?, functions_id = ?, active = ?, country = ?, privis_id = ? where id = ?";


	@Override
	public UserPrivilege save(UserPrivilege element, User user) {

		try(Connection conn = this.createConnection()){
			PreparedStatement statement = null;
			if(element.getId()!=null)
			{
				statement = conn.prepareStatement(UPDATE_USERPRIVILEGE, new String[] {"ID"});
				statement.setInt(6, element.getId());
			}
			else
			{
				statement = conn.prepareStatement(INSERT_USERPRIVILEGE, new String[] {"ID"});
			}
			statement.setInt(1, user.getId());
			if(element instanceof FunctionUserPrivilege)
			{
				statement.setInt(2, ((FunctionUserPrivilege)element).getFunction().getId());
			}
			else
			{
				statement.setNull(2, Types.INTEGER);
			}
			statement.setInt(3, element.isActive() ? 1 : 0);
			if(element instanceof FunctionResponsibleUserPrivilege)
			{
				statement.setString(4,  ((FunctionResponsibleUserPrivilege)element).getCountry());
			}
			else
			{
				statement.setNull(4, Types.CHAR);
			}
			statement.setInt(5, element.getPrivilegeType().getId());
			
			statement.executeUpdate();
			
			ResultSet rs = statement.getGeneratedKeys();
			
			if(rs.next())
			{
				element.setId(rs.getInt("ID"));
			}
			
			
		}catch(SQLException e) {
			element = null;
			e.printStackTrace();
		}
		return element;
	}
	
	/**
	 * can only update boolean active from existing userprivilege, since user must be known.
	 */
	@Override
	public UserPrivilege save(UserPrivilege element) {
		try(Connection conn = this.createConnection()){
			PreparedStatement statement;
			if(element.getId()!= null)
			{
				statement = conn.prepareStatement(UPDATE_ACTIVE_FROM_USERPRIVILEGE, new String[] {"ID"});
				statement.setInt(2, element.getId());
				statement.setInt(1, element.isActive()? 1 : 0);
				
				statement.executeUpdate();
			}
			else
			{
				element = null;
			}
		} catch (SQLException e) {
        //TODO throw exception!
        e.printStackTrace();
		}
		return element;
	}
	
	
	@Override
	public UserPrivilege getElement(UserPrivilege element) {
		UserPrivilege userPrivilege =  null;
		try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("select * from userprivileges where id = ?");
            statement.setInt(1, element.getId());

            ResultSet rs =  statement.executeQuery();
            
            if(rs.next()){
            	PrivilegeType type = determinePrivilegeType(rs.getInt("PRIVIS_ID"));
                if (PrivilegeType.TEAMMEMBER == type) {
                	//TODO GET DATE from database

                	userPrivilege = new TeamMemberUserPrivilege(type, "1".equalsIgnoreCase(rs.getString("ACTIVE")), fs.getElement(new Function(rs.getInt("FUNCTIONS_ID"))), null);

                }
                else if(PrivilegeType.FUNCTIONRESPONSIBLE == type) {

                	userPrivilege = new FunctionResponsibleUserPrivilege(type, "1".equalsIgnoreCase(rs.getString("ACTIVE")), fs.getElement(new Function(rs.getInt("FUNCTIONS_ID"))), rs.getString("COUNTRY"));
                }
                else {

                	userPrivilege = new UserPrivilege(type, "1".equalsIgnoreCase(rs.getString("ACTIVE"))); 
                }

                userPrivilege.setId(element.getId());
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userPrivilege;
	}

	@Override
	public Collection<UserPrivilege> getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteElement(UserPrivilege element) {
		// TODO Auto-generated method stub
		
	}
	

    private PrivilegeType determinePrivilegeType(Integer typeId){
        PrivilegeType p = null;
        for (PrivilegeType pt : PrivilegeType.values()) {
        	if (pt.getId() == typeId) {
        		p = pt;
        	}
        }
        return p;
    }

    
    public Function getFunctionFromUserPrivileges(UserPrivilege privilege) {
    	Function function = null;
    	try(Connection conn = this.createConnection()){
    		PreparedStatement statement = conn.prepareStatement("select * from userprivileges where id = ?");
    		statement.setInt(1,  privilege.getId());
    		
    		ResultSet rs = statement.executeQuery();
    		
    		if(rs.next()) {
    			function = fs.getElement(new Function(rs.getInt("function_id")));
    		}
    		}catch (SQLException e) {
    			e.printStackTrace();
    		}
    	return function;
    	
    }
    
    
	@Override
	public User getUserfromUserPrivileges(UserPrivilege privilege) {
		User user =  null;
		try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("select * from userprivileges where id = ?");
            statement.setInt(1, privilege.getId());

            ResultSet rs =  statement.executeQuery();
            
            if(rs.next()){
                	user = us.getElement(new User(rs.getInt("user_id")));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
	}
	
	public UserPrivilege convertToSingleUserPrivilege(ResultSet rs) throws SQLException
	{
		UserPrivilege userPrivilege = null;
		if(rs.next())
		{
			PrivilegeType type = determinePrivilegeType(rs.getInt("privis_id"));
			if(type.equals(PrivilegeType.TEAMMEMBER))
			{
				//TODO localDate toevoegen
				
				userPrivilege = new TeamMemberUserPrivilege(type, rs.getInt("active") == 0 ? false : true, fs.getElement(new Function(rs.getInt("functions_id"))), null);
				userPrivilege.setId(rs.getInt("id"));
			}
			if(type.equals(PrivilegeType.FUNCTIONRESPONSIBLE))
			{
				userPrivilege = new FunctionResponsibleUserPrivilege(type, rs.getInt("active") == 0 ? false : true, fs.getElement(new Function(rs.getInt("functions_id"))), rs.getString("country") );
				userPrivilege.setId(rs.getInt("id"));
			}
			else
			{
				userPrivilege = new UserPrivilege(type, rs.getInt("active") == 0 ? false : true);
				userPrivilege.setId(rs.getInt("id"));
			}
		
		}
	return userPrivilege;
	}

}