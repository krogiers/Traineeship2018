package colruyt.pcrsejb.service.bl;

import java.util.Collection;
import java.util.List;

import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.User.DbUserService;
import colruyt.pcrsejb.service.dl.User.MemoryUserService;
import colruyt.pcrsejb.service.dl.User.UserService;

public class UserServiceBL{

	// Altijd op Abstract werken.
	private UserService userdb = new DbUserService();
    
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

	public void addUser(User newUser) {
		userdb.addElement(newUser);
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
		this.userdb.addPrivilegesToUser(privilege, user);
    }
}
