package colruyt.pcrsejb.service.dl.User;

import java.util.List;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.GenericCrudService;

public interface UserService extends GenericCrudService<User,Integer>{

    List<User> findUsersByPrivilege(UserPrivilege privilege);
    List<User> findUsersByFirstName(String name);
    List<User> findUsersByShortName(String shortName);
}