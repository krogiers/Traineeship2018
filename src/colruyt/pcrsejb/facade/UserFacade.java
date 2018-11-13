package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeBoConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.UserServiceBL;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import java.util.ArrayList;
import java.util.List;

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

	public UserBo saveUser(UserBo user) {
		try {
			return userConverter.convertTo(userServiceBL.saveUser(userBoConverter.convertTo(user)));
		} catch (ValidationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
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
	
	public boolean hasPrivilege(UserBo userBo, UserPrivilegeBo userPrivilegeBo)
	{
		boolean hasPrivilege = false;
		for(UserPrivilegeBo p : userBo.getPrivilegeBoHashSet())
		{
			if(p.getPrivilegeType().equals(userPrivilegeBo.getPrivilegeType()) & p.isActive()==userPrivilegeBo.isActive())
			{
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}
}
