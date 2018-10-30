package colruyt.pcrsejb.entity.privileges;

import colruyt.pcrsejb.entity.function.Function;

public abstract class FunctionHoldingPrivilege extends Privilege{


    private Function function;

    
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "FunctionHoldingPrivilege [function=" + function + "]";
	}
}
