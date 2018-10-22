package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.user.User;

import java.util.HashSet;

/**
 * Class for converting a User Entity into a User BO
 */
public class UserConverter implements GenericConverter<UserBo,User> {


    @Override
    public UserBo convertTo(User from) {
       return new UserBo(from.getFirstName(), from.getLastName(), from.getEmail(), from.getPassword(), from.getPrivileges());
    }
}
