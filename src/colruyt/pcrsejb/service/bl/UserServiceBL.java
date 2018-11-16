package colruyt.pcrsejb.service.bl;
import java.util.*;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import colruyt.pcrsejb.service.dl.userPrivilege.DbUserPrivilegeService;
import colruyt.pcrsejb.util.exceptions.bl.FunctionResponsibleAlreadyAssignedException;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.validators.user.UserValidator;

public class UserServiceBL{
	// Altijd op Abstract werken.
	private UserService userdb = new DbUserService();
	private UserValidator userValidator = new UserValidator();
	private DbUserPrivilegeService dbUserPrivilegeService = new DbUserPrivilegeService();
	//private PrivilegeDl

	/**
	 * Methode voor het navragen van privilege
	 * 
	 * @return hasPrivilege
	 */
	public boolean userHasPrivilege(User user, PrivilegeType privilege) {

		boolean hasPrivilege = false;
		for (UserPrivilege privi : user.getPrivileges()) {
			if (privi.getPrivilegeType() == privilege) {
				hasPrivilege = true;
			}
		}
		return hasPrivilege;
	}
	

	public User saveUser(User user) throws ValidationException {
		userValidator.validate(user);
		return userdb.save(user);
	}

	public Collection<User> getAllUsers() {
		return userdb.getAllElements();
	}

	public List<User> getUserByShortName(String shortName){
		return userdb.findUsersByShortName(shortName);
	}

	public List<User> findUsersByPrivilege(UserPrivilege privilege){
		return this.userdb.findUsersByPrivilege(privilege);
	}

	public List<User> findUsersByFirstName(String name){
		return this.userdb.findUsersByFirstName(name);
	}


    public void addPrivilegeForUser(UserPrivilege privilege, User user) throws FunctionResponsibleAlreadyAssignedException {
		if (privilege.getPrivilegeType() == PrivilegeType.FUNCTIONRESPONSIBLE) {
			checkFunctionResponsible((FunctionResponsibleUserPrivilege) privilege, user);
		}
		HashSet<UserPrivilege> privis = user.getPrivileges();
		privis.add(privilege);
		user.setPrivileges(privis);
		userdb.save(user);
    }

    public void checkFunctionResponsible(FunctionResponsibleUserPrivilege privilege, User user)
			throws FunctionResponsibleAlreadyAssignedException {
		// find all users with the FunctionResponsibleUserPrivilege as active
		List<User> functionResponsible = this.userdb.getFunctionResponsible(privilege.getFunction().getId(), privilege.getCountry());

		if(functionResponsible.size() != 0) {
			throw new FunctionResponsibleAlreadyAssignedException("Function responsible already taken");
		}
	}

	public Map<User, FunctionResponsibleUserPrivilege> getAllFunctionResponsibles(){
		return userdb.getFunctionResponsibles();
	}

	public void delete(User user) {
		userdb.deleteElement(user);
	}

	public User getUser(User user) {
		return userdb.getElement(user);
	}
	

	 public Function getFunctionForPerson(User user) {
	    	
	    
	    	
	    	Function bo = null;
	    	
	    	for(UserPrivilege p : user.getPrivileges()) {
	    		
	    		if(p.isActive() && p.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER)) {
	    			
	    			
	    			TeamMemberUserPrivilege fp = (TeamMemberUserPrivilege) p;
	    			
	    			bo = fp.getFunction();
	    			
	    			
	    			
	    		}
	    		
	    	}
	    	
	    	return bo;
	    	
	    	
	    	
	    }
	 
	 
	 public Function getFunctionForFunctionResponsible(User user) {
	    	
	    	
	    	
	    	Function bo = null;
	    	
	    	for(UserPrivilege p : user.getPrivileges()) {
	    		
	    		if(p.isActive() && p.getPrivilegeType().equals(PrivilegeType.FUNCTIONRESPONSIBLE)){
	    			FunctionResponsibleUserPrivilege fp = (FunctionResponsibleUserPrivilege) p;
	    			bo = fp.getFunction();
	    		}
	    		
	    	}
	    	
	    	return bo;
	    }
	 
	 		public User getUserByEmail(String email) {
				return userdb.getElementByEmail(email);
			} 
	 		
	 		
	 		public User alterStatusOfAdminPrivilege(User user)
	 		{
	 			UserPrivilege adminPrivilege = null;
	 			for(UserPrivilege p : user.getPrivileges())
	 			{
	 				if(p.getPrivilegeType().equals(PrivilegeType.ADMINISTRATOR))
	 				{
	 					adminPrivilege = p;
	 				}
	 			}
	 			adminPrivilege.setActive(!(adminPrivilege.isActive()));
	 			
	 			//dbUserPrivilegeService.save(adminPrivilege);
	 			
	 			dbUserPrivilegeService.save(adminPrivilege, user);
	 			return user;
	 			
	 		} 
		 

	    
}
