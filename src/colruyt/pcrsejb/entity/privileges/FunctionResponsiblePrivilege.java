package colruyt.pcrsejb.entity.privileges;

import colruyt.pcrsejb.entity.function.Function;

public class FunctionResponsiblePrivilege extends FunctionHoldingPrivilege {

	private String country;

	public FunctionResponsiblePrivilege() {
		super();
	}

	public FunctionResponsiblePrivilege(String country) {
		super();
		setCountry(country);
	}

	public FunctionResponsiblePrivilege(String country, Function function) {
		super();
		setCountry(country);
		setFunction(function);
	}




	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Override
	public String toString() {
		return "FunctionResponsiblePrivilege [function=" + this.getFunction() + "]";
	}
}
