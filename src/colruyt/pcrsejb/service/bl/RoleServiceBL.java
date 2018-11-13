package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.dl.role.DbRoleService;
import colruyt.pcrsejb.service.dl.role.RoleService;

import java.util.List;

import java.util.Collection;

public class RoleServiceBL {

	private RoleService roledb = new DbRoleService();

    public List<Role> getAllRolesForFunction(Function function) {
        return roledb.getAllRolesForFunction(function);
    }

	public Collection<Role> getAllRoles() {
		return roledb.getAllElements();
	}

    public void save(Role role) {
		roledb.save(role);
    }
}
