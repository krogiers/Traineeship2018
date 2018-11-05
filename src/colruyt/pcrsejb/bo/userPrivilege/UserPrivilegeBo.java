package colruyt.pcrsejb.bo.userPrivilege;

public class UserPrivilegeBo {
	private Integer id;
	private PrivilegeTypeBo privilegeType;
	private boolean active;
	
	public UserPrivilegeBo(PrivilegeTypeBo privilegeType, boolean active) {
		setPrivilegeType(privilegeType);
		setActive(active);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public PrivilegeTypeBo getPrivilegeType() {
		return privilegeType;
	}

	public void setPrivilegeType(PrivilegeTypeBo privilegeType) {
		this.privilegeType = privilegeType;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
