package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.entity.function.Function;

public abstract class FunctionHoldingPrivilegeBo implements PrivilegeBo {

	
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
