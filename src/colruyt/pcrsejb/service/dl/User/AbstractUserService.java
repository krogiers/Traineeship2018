package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.List;

public interface AbstractUserService extends GenericCrudService<User,Long>{

    List<User> findUsersByPrivilege(Privilege privilege);
    List<User> findUsersByFirstName(String name);

}