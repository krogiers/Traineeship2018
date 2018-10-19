package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.user.User;

import java.util.HashSet;

/**
 * Class for converting a User Entity into a User BO
 */
public class UserConverter {


    public UserBo convertUser(User user){
        UserBo userBo = new UserBo(user.getFirstName(), user.getLastName(), user.getEmail(), user.getPassword(), user.getPrivileges());
        return userBo;
    }
}
