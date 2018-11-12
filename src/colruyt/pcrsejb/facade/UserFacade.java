package colruyt.pcrsejb.facade;

import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeBoConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.bl.UserServiceBL;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;

public class UserFacade {
	private UserServiceBL userServiceBL = new UserServiceBL();
	private UserBoConverter userBoConverter = new UserBoConverter();
	private UserConverter userConverter = new UserConverter();
	private UserPrivilegeBoConverter userPrivilegeBoConverter = new UserPrivilegeBoConverter();

	public List<UserBo> getAllUsers() {
		List<UserBo> users = new ArrayList<>();
		for (User u : userServiceBL.getAllUsers()) {
			users.add(userConverter.convertTo(u));
		}
		return users;
	}

	public List<UserBo> searchUsers(String shortString) {
		List<UserBo> matchingUsers = new ArrayList<>();
		for (User u : userServiceBL.getUserByShortName(shortString)) {
			matchingUsers.add(userConverter.convertTo(u));
		}
		return matchingUsers;
	}

	/**
	 * Methode die een userBo object ontvangt en een user object doorgeeft zodat
	 * deze kan verwijderd worden
	 * 
	 * @param user
	 */
	public void removeUser(UserBo user) {
		userServiceBL.delete(userBoConverter.convertTo(user));
	}

	public void saveUser(UserBo user) {
		try {
			userServiceBL.saveUser(userBoConverter.convertTo(user));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

    public List<UserBo> getAllFunctionResponsibles() {
		List<UserBo> functionResponsibleList = new ArrayList<>();
		for (User u: userServiceBL.getAllFunctionResponsibles()){
			functionResponsibleList.add(userConverter.convertTo(u));
		}
		return functionResponsibleList;
    }

	public void addPrivilegeForUser(UserPrivilegeBo privilegeBo, UserBo userBo) {
		userServiceBL.addPrivilegeForUser(userPrivilegeBoConverter.convertTo(privilegeBo), userBoConverter.convertTo(userBo));
	}

	public UserBo getUser(UserBo userBo) {
		return userConverter.convertTo(userServiceBL.getUser(userBoConverter.convertTo(userBo)));
	}
}
