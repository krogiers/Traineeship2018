package colruyt.pcrsejb.bo.enrolment;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;

public class EnrolmentBo {

	private UserBo userBo;
	private UserPrivilegeBo privilegeBo;
	private boolean active;
	private Integer id;

	public EnrolmentBo() {}

	public EnrolmentBo(UserBo userBo, UserPrivilegeBo privilegeBo, boolean active) {
		this.userBo = userBo;
		this.privilegeBo = privilegeBo;
		this.active = active;
	}


	public void setUserBo(UserBo userBo) {
		this.userBo = userBo;
	}

	public UserPrivilegeBo getPrivilegeBo() {
		return privilegeBo;
	}

	public void setPrivilegeBo(UserPrivilegeBo privilegeBo) {
		this.privilegeBo = privilegeBo;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public UserBo getUserBo() {
		return userBo;
	}

	@Override
	public boolean equals(Object o) {
		boolean gelijk = false;
		try {
			if (this.getUserBo().getEmail().equalsIgnoreCase(((EnrolmentBo)o).getUserBo().getEmail()) && this.getPrivilegeBo().getId() == ((EnrolmentBo)o).getPrivilegeBo().getId()) {
				gelijk = true;
			}
		}
		catch (Exception ex)
		{
			gelijk = false;
		}
		return gelijk;
	}
	
}
