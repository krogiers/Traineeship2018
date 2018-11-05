package colruyt.pcrsejb.entity.userPrivilege;

public enum PrivilegeType {
	TEAMMEMBER(1,"M", "Team member"), TEAMMANAGER(2,"T", "Team manager"), FUNCTIONRESPONSIBLE(3,"F", "Function Responsible"), DIRECTOR(4,"D","Directie"),ADMINISTRATOR(5,"A", "Administrator");
	
	private String shortName;
	private String fullName;
	private Integer id;
	
	PrivilegeType(Integer id, String shortName, String fullName) {
		this.shortName = shortName;
		this.id = id;
		this.fullName = fullName;
	}

	public String getShortName() {
		return shortName;
	}

	public void setShortName(String shortName) {
		this.shortName = shortName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
