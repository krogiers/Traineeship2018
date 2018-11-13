package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.role.RoleBoConverter;
import colruyt.pcrsejb.converter.role.RoleConverter;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.bl.RoleServiceBL;

import java.util.ArrayList;
import java.util.List;

public class RoleFacade {

	private RoleServiceBL roleServiceBL= new RoleServiceBL();
	private RoleBoConverter roleBoConverter = new RoleBoConverter();
	private RoleConverter roleConverter = new RoleConverter();


	public List<RoleBo> getAllRoles(){
		List<RoleBo> roleBoList = new ArrayList<>();
		for (Role role : roleServiceBL.getAllRoles()){
			roleBoList.add(roleConverter.convertTo(role));
		}
		return roleBoList;
	}
}
