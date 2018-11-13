package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
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

	public List<RoleBo> getAllRolesForFunction(FunctionBo functionBo) {
		List<RoleBo> roleBoList = new ArrayList<>();
		FunctionBoConverter conv = new FunctionBoConverter();
		for (Role role : roleServiceBL.getAllRolesForFunction(conv.convertTo(functionBo))){
			roleBoList.add(roleConverter.convertTo(role));
		}
		return roleBoList;
	}

	public List<RoleBo> getAllRoles() {
		List<RoleBo> roles = new ArrayList<>();
		for (Role r : roleServiceBL.getAllRoles()) {
			roles.add(roleConverter.convertTo(r));
		}
		return roles;
	}


    public void save(RoleBo role) {
		roleServiceBL.save(roleBoConverter.convertTo(role));
    }
}
