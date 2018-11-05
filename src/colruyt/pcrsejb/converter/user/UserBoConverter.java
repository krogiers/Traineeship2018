package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeBoConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

import java.util.HashSet;

public class UserBoConverter implements GenericConverter<User,UserBo> {



    @Override
    public User convertTo(UserBo from) {
    	
        return new User(from.getId(), from.getFirstName(), from.getLastName(), from.getEmail(), from.getPassword(),
				getUserPrivileges((HashSet<UserPrivilegeBo>) from.getPrivilegeBoHashSet()), from.getCountry());
    }
    
    private HashSet<UserPrivilege> getUserPrivileges(HashSet<UserPrivilegeBo> privs) {
		HashSet<UserPrivilege> UserPrivileges = new HashSet<>();
		UserPrivilegeBoConverter conv = new UserPrivilegeBoConverter();
		for (UserPrivilegeBo pr : privs) {
			UserPrivileges.add(conv.convertTo(pr));
		}
		return UserPrivileges;
    }
}
