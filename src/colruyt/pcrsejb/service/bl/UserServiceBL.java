package colruyt.pcrsejb.service.bl;

import java.util.Collection;
import java.util.List;

import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.User.MemoryUserService;

public class UserServiceBL{
	private MemoryUserService userdb = new MemoryUserService();
    
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
	
	

}
