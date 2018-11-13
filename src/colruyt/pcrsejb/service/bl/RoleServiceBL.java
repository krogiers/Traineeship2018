package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.dl.role.DbRoleService;
import colruyt.pcrsejb.service.dl.role.RoleService;

import java.util.Collection;

public class RoleServiceBL {

	private RoleService roledb = new DbRoleService();

	public Collection<Role> getAllRoles() {
		return roledb.getAllElements();
	}
	
}
