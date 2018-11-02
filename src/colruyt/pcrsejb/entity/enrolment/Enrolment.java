package colruyt.pcrsejb.entity.enrolment;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

public class Enrolment {

	private Integer EnrolmentID;
	private User user;
	private UserPrivilege privilege;
	private boolean active;
	
	public Enrolment() {};
	public Enrolment(User user, UserPrivilege privilege, boolean active) {
		this.user = user;
		this.privilege = privilege;
		this.active = active;
	}

	public Enrolment(Integer enrolmentID, colruyt.pcrsejb.entity.user.User user, UserPrivilege privilege, boolean active) {
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
	
	public Integer getEnrolmentID() {
		return EnrolmentID;
	}
	public void setEnrolmentID(Integer enrolmentID) {
		EnrolmentID = enrolmentID;
	}
	public UserPrivilege getPrivilege() {
		return privilege;
	}
	public void setPrivilege(UserPrivilege privilege) {
		this.privilege = privilege;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	
}
