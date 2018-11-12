package colruyt.pcrsejb.entity.operatingunit;

public class OperatingUnit {

	private int operatingUnitId;
	private String operatingUnitName;

	public OperatingUnit(int operatingUnitId, String operatingUnitName) {
		this.operatingUnitId = operatingUnitId;
		this.operatingUnitName = operatingUnitName;
	}

	public int getOperatingUnitId() {
		return operatingUnitId;
	}

	public void setOperatingUnitId(int operatingUnitId) {
		this.operatingUnitId = operatingUnitId;
	}

	public String getOperatingUnitName() {
		return operatingUnitName;
	}

	public void setOperatingUnitName(String operatingUnitName) {
		this.operatingUnitName = operatingUnitName;
	}
}
