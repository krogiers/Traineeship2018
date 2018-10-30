package colruyt.pcrsejb.service.dl.privilege;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.List;

public interface PrivilegeService extends GenericCrudService<Privilege,Integer> {

    public List<Privilege> findPrivilegesForUser(User u);







}
