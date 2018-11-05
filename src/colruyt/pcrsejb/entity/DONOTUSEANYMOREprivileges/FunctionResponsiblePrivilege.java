package colruyt.pcrsejb.entity.DONOTUSEANYMOREprivileges;

import colruyt.pcrsejb.entity.function.Function;

public class FunctionResponsiblePrivilege extends FunctionHoldingPrivilege {

	private String country;

	public FunctionResponsiblePrivilege() {
		super();
		this.setId(3);
	}

	public FunctionResponsiblePrivilege(String country) {
		super();
		setCountry(country);
		this.setId(3);
	}

	public FunctionResponsiblePrivilege(String country, Function function) {
		super();
		setCountry(country);
		setFunction(function);
		this.setId(3);
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
