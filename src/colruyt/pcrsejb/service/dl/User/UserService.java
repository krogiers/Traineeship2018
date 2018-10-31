package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.List;

public interface UserService extends GenericCrudService<User,Integer>{

    List<User> findUsersByPrivilege(Privilege privilege);
    List<User> findUsersByFirstName(String name);
    List<User> findUsersByShortName(String shortName);
    void addPrivilegesToUser(Privilege privi, User user);


}