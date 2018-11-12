package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

import java.util.HashSet;

/**
 * Class for converting a user Entity into a user BO
 */
public class UserConverter implements GenericConverter<UserBo,User> {


    @Override
    public UserBo convertTo(User from) {
    	UserBo userBo = new UserBo(from.getId(),from.getFirstName(), from.getLastName(), from.getEmail(),
			   from.getPassword(), getPrivileges(from.getPrivileges()), from.getCountry());
    	userBo.setFunctionForFunctionResponsible(null);
    	userBo.setHasActiveAdminRights(false);
    	userBo.setHasInactiveAdminRights(false);
    	FunctionConverter fv = new FunctionConverter();
    	for(UserPrivilege p : from.getPrivileges())
    	{
    		if(p.getPrivilegeType().equals(PrivilegeType.ADMINISTRATOR) & p.isActive())
    		{
    			userBo.setHasActiveAdminRights(true);
    		}
    		if(p.getPrivilegeType().equals(PrivilegeType.ADMINISTRATOR) & !p.isActive())
    		{
    			userBo.setHasInactiveAdminRights(true);
    		}
    		if(p.getPrivilegeType().equals(PrivilegeType.FUNCTIONRESPONSIBLE) & p.isActive())
    		{
    			userBo.setFunctionForFunctionResponsible(fv.convertTo(((FunctionUserPrivilege)p).getFunction()));
    		}
    	}
       return userBo;
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
