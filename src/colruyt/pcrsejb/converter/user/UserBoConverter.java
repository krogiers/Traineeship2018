package colruyt.pcrsejb.converter.user;

import java.util.HashSet;

import colruyt.pcrsejb.bo.privileges.AdminPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.DirectorPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.FunctionResponsiblePrivilegeBo;
import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamManagerPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamMemberPrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.privilege.PrivilegeBoConverter;
import colruyt.pcrsejb.converter.privilege.PrivilegeConverter;
import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.DirectorPrivilege;
import colruyt.pcrsejb.entity.privileges.FunctionResponsiblePrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.user.User;

public class UserBoConverter implements GenericConverter<User,UserBo> {



    @Override
    public User convertTo(UserBo from) {
    	
        return new User(from.getId(), from.getFirstName(), from.getLastName(), from.getEmail(), from.getPassword(),
				getPrivileges((HashSet<PrivilegeBo>) from.getPrivilegeBoHashSet()), from.getCountry());
    }
    
    private HashSet<Privilege> getPrivileges(HashSet<PrivilegeBo> privs) {
		HashSet<Privilege> privileges = new HashSet<>();
		PrivilegeBoConverter conv = new PrivilegeBoConverter();
		for (PrivilegeBo pr : privs) {
			privileges.add(conv.convertTo(pr));
		}
		return privileges;
    }
}
