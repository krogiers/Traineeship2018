package colruyt.pcrsejb;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.facade.FunctionFacade;
import colruyt.pcrsejb.facade.UserFacade;

public class Main {

    public static void main(String[] args) {
        UserFacade userFacade = new UserFacade();
        System.out.println(userFacade.getUsersByShortName("womos"));



    }
}