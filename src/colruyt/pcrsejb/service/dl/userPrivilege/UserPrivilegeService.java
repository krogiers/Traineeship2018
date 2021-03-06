package colruyt.pcrsejb.service.dl.userPrivilege;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.GenericCrudService;

public interface UserPrivilegeService extends GenericCrudService<UserPrivilege,Integer>{

	User getUserfromUserPrivileges(UserPrivilege privilege);
	UserPrivilege save(UserPrivilege privilege, User user);
	
}