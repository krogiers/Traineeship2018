package colruyt.pcrsejb.entity.userPrivilege;

import colruyt.pcrsejb.entity.function.Function;

public class FunctionUserPrivilege extends UserPrivilege {
	
	private Function function;


	
	public FunctionUserPrivilege(PrivilegeType privilegeType, boolean active, Function function) {
		super(privilegeType, active);
		setFunction(function);
	}
	
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
}
