package colruyt.pcrsejb.entity.enrolment;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

public class Enrolment {

	private long EnrolmentID;
	private User user;
	private Privilege privilege;
	private boolean active;
	
	public Enrolment() {};
	public Enrolment(User user, Privilege privilege, boolean active) {
		this.user = user;
		this.privilege = privilege;
		this.active = active;
	}

	public Enrolment(long enrolmentID, colruyt.pcrsejb.entity.user.User user, colruyt.pcrsejb.entity.privileges.Privilege privilege, boolean active) {
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
