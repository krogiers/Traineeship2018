package colruyt.pcrsejb;

import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.facade.UserFacade;

public class Main {

    public static void main(String[] args) {
        UserBo userBo = new UserBo();
        UserFacade uf = new UserFacade();

        userBo.setId(10);
        System.out.println(uf.getUser(userBo));


    }
}