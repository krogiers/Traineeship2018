package colruyt.pcrsejb.bo.userPrivilege;

import colruyt.pcrsejb.bo.function.FunctionBo;

public class FunctionResponsibleUserPrivilegeBo extends FunctionUserPrivilegeBo {
	
	private String country;
	
	public FunctionResponsibleUserPrivilegeBo(PrivilegeTypeBo privilegeType, boolean active, FunctionBo function, String country) {
		super(privilegeType, active, function);
		setCountry(country);
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
}
