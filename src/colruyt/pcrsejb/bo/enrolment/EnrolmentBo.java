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
	public UserBo getUserBO() {
		return userBo;
	}

	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public PrivilegeBo getPrivilegeBo() {
		return privilegeBo;
	}

	public void setPrivilegeBo(PrivilegeBo privilegeBo) {
		this.privilegeBo = privilegeBo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
}
