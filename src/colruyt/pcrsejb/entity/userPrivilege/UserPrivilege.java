package colruyt.pcrsejb.entity.userPrivilege;

public class UserPrivilege {
	private Integer id;
	private PrivilegeType privilegeType;
	private boolean active;
	
	public UserPrivilege(PrivilegeType privilegeType, boolean active) {
		setPrivilegeType(privilegeType);
		setActive(active);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PrivilegeType getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(PrivilegeType privilegeType) {
		this.privilegeType = privilegeType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
