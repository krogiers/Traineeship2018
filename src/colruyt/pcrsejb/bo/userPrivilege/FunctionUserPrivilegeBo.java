package colruyt.pcrsejb.bo.userPrivilege;

import colruyt.pcrsejb.bo.function.FunctionBo;

public class FunctionUserPrivilegeBo extends UserPrivilegeBo {
	
	private FunctionBo function;
	
	public FunctionUserPrivilegeBo(PrivilegeTypeBo privilegeType, boolean active, FunctionBo function) {
		super(privilegeType, active);
		setFunction(function);
	}
	
	public FunctionBo getFunction() {
		return function;
	}

	public void setFunction(FunctionBo function) {
		this.function = function;
	}
}
