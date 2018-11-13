package colruyt.pcrsejb.entity.operatingunit;

public class OperatingUnit {

	private Integer id;
	private String operatingUnitName;

	public OperatingUnit(Integer id, String operatingUnitName) {
		setId(id);
		setOperatingUnitName(operatingUnitName);
	}
	
	public OperatingUnit(Integer id) {
		setId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getOperatingUnitName() {
		return operatingUnitName;
	}

	public void setOperatingUnitName(String operatingUnitName) {
		this.operatingUnitName = operatingUnitName;
	}
}
