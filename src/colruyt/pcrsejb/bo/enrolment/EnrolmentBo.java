package colruyt.pcrsejb.bo.enrolment;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;

public class EnrolmentBo {

	private UserBo userBo;
	private PrivilegeBo privilegeBo;
	private boolean active;

	public EnrolmentBo() {};

	public EnrolmentBo(UserBo userBo, PrivilegeBo privilegeBo, boolean active) {
		this.userBo = userBo;
		this.privilegeBo = privilegeBo;
		this.active = active;
	}
	public UserBo getUser() {
		return userBo;
	}

	public void setUser(UserBo userBo) {
		this.userBo = userBo;
	}

	public PrivilegeBo getPrivilege() {
		return privilegeBo;
	}

	public void setPrivilege(PrivilegeBo privilegeBo) {
		this.privilegeBo = privilegeBo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
