package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.user.DbUserService;
import colruyt.pcrsejb.service.dl.user.UserService;
import colruyt.pcrsejb.util.exceptions.validation.ValidationException;
import colruyt.pcrsejb.util.validators.user.UserValidator;

import java.util.Collection;
import java.util.List;

public class UserServiceBL{

	// Altijd op Abstract werken.
	private UserService userdb = new DbUserService();
	private UserValidator userValidator = new UserValidator();
    
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

	public void saveUser(User user) throws ValidationException {
		userValidator.validate(user);
		userdb.save(user);
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


    public void addPrivilegeForUser(UserPrivilege privilege, User user) {
		if (privilege.getPrivilegeType() == PrivilegeType.FUNCTIONRESPONSIBLE) {
			checkFunctionResponsible((FunctionResponsibleUserPrivilege) privilege, user);
		}
		userdb.save(user);
    }

    public void checkFunctionResponsible(FunctionResponsibleUserPrivilege privilege, User user){
		System.out.println("1");
		for (User u :this.userdb.findUsersByPrivilege(privilege)){
			System.out.println("2");
			for (UserPrivilege p : u.getPrivileges()) {
				System.out.println("3");
				if (p.getPrivilegeType() == PrivilegeType.FUNCTIONRESPONSIBLE) {
					System.out.println("4");
					
					FunctionResponsibleUserPrivilege frp = (FunctionResponsibleUserPrivilege) p;
					System.out.println(frp.getFunction().getId());
					System.out.println(frp.getCountry());
					System.out.println(privilege.getFunction().getId());
					System.out.println(privilege.getCountry());

					if (frp.getFunction().getId().equals(privilege.getFunction().getId()) &&
							frp.getCountry().equals(privilege.getCountry())) {
						System.out.println("5");
						throw new UnsupportedOperationException("Function Reponsible already taken for this function and country.");
					}

				}
			}
		}
	}

	public void delete(User user) {
		userdb.deleteElement(user);
	}

	public User getUser(User user) {
		return userdb.getElement(user);
	}
}
