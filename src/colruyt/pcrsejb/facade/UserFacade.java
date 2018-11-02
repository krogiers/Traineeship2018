package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.privilege.PrivilegeBoConverter;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.UserServiceBL;

import java.util.ArrayList;
import java.util.List;

public class UserFacade {
	private UserServiceBL userServiceBL = new UserServiceBL();
	private UserBoConverter userBoConverter = new UserBoConverter();
	private UserConverter userConverter = new UserConverter();
	private PrivilegeBoConverter privilegeBoConverter = new PrivilegeBoConverter();

	public List<UserBo> getAllUsers() {
		List<UserBo> users = new ArrayList<>();
		for (User u : userServiceBL.getAllUsers()) {
			users.add(userConverter.convertTo(u));
		}
		return users;
	}

	public List<UserBo> searchUsers(String shortString) {
		List<UserBo> matchingUsers = new ArrayList<>();
		for (User u : userServiceBL.getUserByShortName(shortString)){
			matchingUsers.add(userConverter.convertTo(u));
		}
		return matchingUsers;
	}

	public void removeUser(UserBo user) {
		userServiceBL.delete(userBoConverter.convertTo(user));
	}

	//public void saveUser(UserBo user) {
		//userServiceBL.saveUser(userBoConverter.convertTo(user));
	//}

    public List<UserBo> getFunctionResponsibles() {
		return null;
    }

	public void addPrivilegeForUser(PrivilegeBo privilegeBo, UserBo userBo) {
		userServiceBL.addPrivilegeForUser(privilegeBoConverter.convertTo(privilegeBo), userBoConverter.convertTo(userBo));
	}

    public UserBo getUser(UserBo userBo) {
		return userConverter.convertTo(userServiceBL.getUser(userBoConverter.convertTo(userBo)));
    }
}
