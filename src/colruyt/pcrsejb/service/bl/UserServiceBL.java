package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.privileges.FunctionResponsiblePrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.User.DbUserService;
import colruyt.pcrsejb.service.dl.User.UserService;
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
	public boolean userHasPrivilege(User user, Privilege privilege) {

		boolean hasPrivilege = false;
		for (Privilege privi : user.getPrivileges()) {
			if (privilege.getClass().isInstance(privi)) {
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

	public List<User> findUsersByPrivilege(Privilege privilege){
		return this.userdb.findUsersByPrivilege(privilege);
	}

	public List<User> findUsersByFirstName(String name){
		return this.userdb.findUsersByFirstName(name);
	}


    public void addPrivilegeForUser(Privilege privilege, User user) {
		if (privilege instanceof FunctionResponsiblePrivilege) {
			checkFunctionResponsible((FunctionResponsiblePrivilege) privilege, user);
		}
		userdb.save(user);
    }

    public void checkFunctionResponsible(FunctionResponsiblePrivilege privilege, User user){
		System.out.println("1");
		for (User u :this.userdb.findUsersByPrivilege(privilege)){
			System.out.println("2");
			for (Privilege p : u.getPrivileges()) {
				System.out.println("3");
				if (p instanceof FunctionResponsiblePrivilege) {
					System.out.println("4");
					FunctionResponsiblePrivilege frp = (FunctionResponsiblePrivilege) p;


					if (frp.getFunction().getFunctionID() == privilege.getFunction().getFunctionID() &&
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
