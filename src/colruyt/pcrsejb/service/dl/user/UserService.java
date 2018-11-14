package colruyt.pcrsejb.service.dl.user;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public interface UserService extends GenericCrudService<User,Integer>{

    List<User> findUsersByPrivilege(UserPrivilege privilege);

    List<User> findUsersByFirstName(String name);
    List<User> findUsersByShortName(String shortName);
    List<User> getFunctionResponsible(int functionId, String country);
	User convertToSingleUser(ResultSet rs) throws SQLException;
    List<User> getAllFunctionResponsibles();

	User getElementByEmail(String email);
}