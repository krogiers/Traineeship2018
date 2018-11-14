<<<<<<< HEAD
package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;

import java.util.List;

public class FunctionServiceBL {

    private FunctionService functionService = new DbFunctionService();

    public List<Function> getAllFunctionNames() {
        return (List<Function>) functionService.getAllFunctionNames();
    }
    
    
    

}
=======
package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;

import java.util.List;

public class FunctionServiceBL {

    private FunctionService functionService = new DbFunctionService();

    public List<Function> getAllFunctionNames() {
        return (List<Function>) functionService.getAllFunctionNames();
    }


    public Function getFunction(Function function) {
        return functionService.getElement(function);
    }
}
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
