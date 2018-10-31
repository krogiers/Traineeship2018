package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.bo.function.FunctionBo;

public class FunctionResponsiblePrivilegeBo extends FunctionHoldingPrivilegeBo {

	private String country;

	public FunctionResponsiblePrivilegeBo() {
		super();
		setId(3);
	}

    public FunctionResponsiblePrivilegeBo(String country, FunctionBo functionBo) {
        super();
        setCountry(country);
        setFunctionBo(functionBo);
		setId(3);
    }

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FunctionResponsiblePrivilegeBo [function=" + this.getFunctionBo() + "]";
	}
}
