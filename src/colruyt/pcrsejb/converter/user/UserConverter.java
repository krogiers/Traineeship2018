package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.privileges.AdminPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.DirectorPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.FunctionResponsiblePrivilegeBo;
import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamManagerPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamMemberPrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.privilege.PrivilegeConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.DirectorPrivilege;
import colruyt.pcrsejb.entity.privileges.FunctionResponsiblePrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

import java.util.HashSet;

/**
 * Class for converting a User Entity into a User BO
 */
public class UserConverter implements GenericConverter<UserBo,User> {


    @Override
    public UserBo convertTo(User from) {
       return new UserBo(from.getId(),from.getFirstName(), from.getLastName(), from.getEmail(),
			   from.getPassword(), getPrivileges(from.getPrivileges()), from.getCountry());
    }
    
    private HashSet<UserPrivilegeBo> getPrivileges(HashSet<UserPrivilege> hashSet) {
    	HashSet<UserPrivilegeBo> privileges = new HashSet<>();
		UserPrivilegeConverter conv = new UserPrivilegeConverter();
    	for (UserPrivilege pr : hashSet) {
    		privileges.add(conv.convertTo(pr));
    	}
    	return privileges;
    }
}
