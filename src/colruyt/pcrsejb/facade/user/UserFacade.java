package colruyt.pcrsejb.facade.user;

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

	public void addUser(UserBo newUser, UserBo CurrentUser) {
		userServiceBL.addUser(userBoConverter.convertTo(newUser), userBoConverter.convertTo(CurrentUser));
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
}
