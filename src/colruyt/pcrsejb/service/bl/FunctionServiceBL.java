package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;

import java.util.List;

public class FunctionServiceBL {

    private FunctionService functionService = new DbFunctionService();
    public List<Function> getAllFunctions() {
        return (List<Function>) functionService.getAllFunctions();
    }

}
