package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

import java.util.HashSet;

/**
 * Class for converting a user Entity into a user BO
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
