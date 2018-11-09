package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.converter.role.RoleBoConverter;
import colruyt.pcrsejb.converter.role.RoleConverter;
import colruyt.pcrsejb.service.bl.RoleServiceBL;

public class RoleFacade {

	private RoleServiceBL roleServiceBL= new RoleServiceBL();
	private RoleBoConverter roleBoConverter = new RoleBoConverter();
	private RoleConverter roleConverter = new RoleConverter();
}
