package colruyt.pcrsejb.entity.userPrivilege;

import colruyt.pcrsejb.entity.function.Function;

public class FunctionResponsibleUserPrivilege extends FunctionUserPrivilege {
	
	private String country;
	
	public FunctionResponsibleUserPrivilege(PrivilegeType privilegeType, boolean active, Function function, String country) {
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
