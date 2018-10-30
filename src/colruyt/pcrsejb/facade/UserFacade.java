package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
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

	public void addUser(UserBo newUser) {
		User user = userBoConverter.convertTo(newUser);
		userServiceBL.addUser(user);
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
		List<UserBo> matchingUsers = new ArrayList<>();
		for (User u : userServiceBL.getUserByShortName(shortString)){
			matchingUsers.add(userConverter.convertTo(u));
		}
		return matchingUsers;
	}

	public void removeUser(UserBo user) {
		// TODO
	}

	public void saveUser(UserBo user) {
		// TODO Auto-generated method stub
		
	}

    public void addFunctionResponsible() {
		// TODO
    }

	public void updatePassword(UserBo user) {
		// TODO Auto-generated method stub
		
	}
}
