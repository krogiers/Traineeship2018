package colruyt.pcrsejb.converter.user;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;

import java.util.HashSet;

public class UserBoConverter implements GenericConverter<User,UserBo> {



    @Override
    public User convertTo(UserBo from) {
        return new User(from.getFirstName(), from.getLastName(), from.getEmail(), from.getPassword(), (HashSet<Privilege>)from.getPrivileges());
    }
}
