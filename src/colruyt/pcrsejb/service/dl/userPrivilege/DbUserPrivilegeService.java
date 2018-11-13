package colruyt.pcrsejb.service.dl.userPrivilege;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DbUserPrivilegeService extends DbService implements UserPrivilegeService {
	private FunctionService fs = new DbFunctionService();

	@Override
	public UserPrivilege save(UserPrivilege element) {
		// TODO Auto-generated method stub
		return null;
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
                UserPrivilege p;
                if (PrivilegeType.TEAMMEMBER == type) {
                	//TODO GET DATE from database
                	p = new TeamMemberUserPrivilege(type, 1 == rs.getInt("ACTIVE"), fs.getElement(new Function(rs.getInt("FUNCTIONS_ID"))), null);
                }
                else if(PrivilegeType.FUNCTIONRESPONSIBLE == type) {
                	p = new FunctionResponsibleUserPrivilege(type, 1 == rs.getInt("ACTIVE"), fs.getElement(new Function(rs.getInt("FUNCTIONS_ID"))), rs.getString("COUNTRY"));
                }
                else {
                	p = new UserPrivilege(type, 1 == rs.getInt("ACTIVE")); 
                }
                userPrivilege = p;
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

}