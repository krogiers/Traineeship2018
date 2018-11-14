package colruyt.pcrsejb.facade;

import java.util.ArrayList;
import java.util.List;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeBoConverter;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

import colruyt.pcrsejb.service.bl.UserServiceBL;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;

public class UserFacade {
	private UserServiceBL userServiceBL = new UserServiceBL();
	private UserBoConverter userBoConverter = new UserBoConverter();
	private UserConverter userConverter = new UserConverter();
	private FunctionConverter functionConverter = new FunctionConverter();
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
	
	 public FunctionBo getFunctionForPerson(UserBo user) {
	    	
	    	User u = this.userBoConverter.convertTo(user);
	    	
	    
	    			
	    		return 	this.functionConverter.convertTo(this.userServiceBL.getFunctionForPerson(u));
	    			
	    			
	    			
	    		
	    
	    	
	    	
	    	
	    }
	    
	 
	 public FunctionBo getFunctionForFunctionResponsible(UserBo user) {
	    	
	    	User u = this.userBoConverter.convertTo(user);
	    	
	    
	    			return this.functionConverter.convertTo(this.userServiceBL.getFunctionForFunctionResponsible(u));
	    		
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
	
	
	public boolean hasPrivilege(UserBo userBo, PrivilegeTypeBo privilegeTypeBo, boolean isActive)
	{
		boolean hasPrivilege = false;
		for(UserPrivilegeBo p : userBo.getPrivilegeBoHashSet())
		{
			if(p.getPrivilegeType().equals(privilegeTypeBo) && p.isActive() == isActive)
			{
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}

	public UserBo getUserByEmail(String email) {
		return userConverter.convertTo(userServiceBL.getUserByEmail(email));
	}
	
	public void alterStatusOfAdminPrivilege(UserBo userBo)
	{
		userServiceBL.alterStatusOfAdminPrivilege(userBoConverter.convertTo(userBo));
	}
}
