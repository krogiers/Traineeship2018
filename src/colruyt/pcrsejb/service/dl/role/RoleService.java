package colruyt.pcrsejb.service.dl.role;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.List;

public interface RoleService extends GenericCrudService<Role,Integer>{


    List<Role> getAllRolesForFunction(Function function);
}