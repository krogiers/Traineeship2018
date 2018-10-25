package colruyt.pcrsejb.facade;

import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.UserServiceBL;

public class UserFacade {
	private UserServiceBL userServiceBL = new UserServiceBL();
	private UserBoConverter userBoConverter = new UserBoConverter();
	private UserConverter userConverter = new UserConverter();

	public void addUser(UserBo newUser) {
		userServiceBL.addUser(userBoConverter.convertTo(newUser));
	}

	public List<UserBo> getAllUsers() {
		List<UserBo> users = new ArrayList<>();
		for (User u : userServiceBL.getAllUsers()) {
			users.add(userConverter.convertTo(u));
		}
		return users;
	}
	
	public void givePrivilegeToUser(UserBo user, UserBo currentUser, PrivilegeBo privilege) {
		//TODO
	}

	public List<UserBo> searchUsers(String shortString) {
		//TODO
		return null;
	}

	public void removeUser(UserBo user) {
		// TODO
	}

	public void saveUser(UserBo user) {
		// TODO Auto-generated method stub
		
	}
}
