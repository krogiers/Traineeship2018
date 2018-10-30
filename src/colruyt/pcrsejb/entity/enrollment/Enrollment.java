package colruyt.pcrsejb.entity.enrollment;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

public class Enrollment {

	private Long EnrolmentID;
	private User user;
	private Privilege privilege;
	private boolean active;
	
	public Enrollment() {};
	public Enrollment(User user, Privilege privilege, boolean active) {
		this.user = user;
		this.privilege = privilege;
		this.active = active;
	}

	public Enrollment(Long enrolmentID, colruyt.pcrsejb.entity.user.User user, colruyt.pcrsejb.entity.privileges.Privilege privilege, boolean active) {
		EnrolmentID = enrolmentID;
		this.user = user;
		this.privilege = privilege;
		this.active = active;
	}

	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Privilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(Privilege privilege) {
		this.privilege = privilege;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
