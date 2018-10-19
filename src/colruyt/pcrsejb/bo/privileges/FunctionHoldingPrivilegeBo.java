package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.entity.function.Function;

public abstract class FunctionHoldingPrivilegeBo implements PrivilegeBo {

	
    private Function function;

    
	public Function getFunction() {
		return function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}

	@Override
	public String toString() {
		return "FunctionHoldingPrivilegeBo [function=" + function + "]";
	}
}
