package colruyt.pcrsejb;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.UserFacade;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
        UserBo userBo = new UserBo();
        UserFacade uf = new UserFacade();
        HashSet<PrivilegeBo> privileges = new HashSet<>();

        userBo.setId(10);
        userBo.setFirstName("Yendel");
        userBo.setLastName("Lintermans");
        userBo.setEmail("test@test.be");
        userBo.setPassword("yendel");
        userBo.setCountry("BE");
        System.out.println(uf.getUser(userBo));


    }
}