package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.bo.function.FunctionBo;

public abstract class FunctionHoldingPrivilegeBo extends PrivilegeBo {

	
    private FunctionBo functionBo;

    
	public FunctionBo getFunctionBo() {
		return functionBo;
	}

	public void setFunctionBo(FunctionBo functionBo) {
		this.functionBo = functionBo;
	}

	@Override
	public String toString() {
		return "FunctionHoldingPrivilegeBo [function=" + functionBo + "]";
	}
}
