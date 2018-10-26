package colruyt.pcrsejb.bo.enrollment;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

public class EnrollmentBo {

	private UserBo user;
	private PrivilegeBo privilege;
	private boolean active;

	public EnrollmentBo() {};
	public EnrollmentBo(UserBo user, PrivilegeBo privilege, boolean active) {
		this.user = user;
		this.privilege = privilege;
		this.active = active;
	}
	public UserBo getUser() {
		return user;
	}
	public void setUser(UserBo user) {
		this.user = user;
	}
	public PrivilegeBo getPrivilege() {
		return privilege;
	}
	public void setPrivilege(PrivilegeBo privilege) {
		this.privilege = privilege;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
