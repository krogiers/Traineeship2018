package colruyt.pcrsejb.entity.user.privileges;

import colruyt.pcrsejb.entity.function.Function;

public abstract class FunctionHoldingPrivilege implements Privilege{

	
    protected Function function;

    
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
