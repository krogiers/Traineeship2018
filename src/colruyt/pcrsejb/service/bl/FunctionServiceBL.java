package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.function.FunctionService;
import colruyt.pcrsejb.service.dl.function.MemoryFunctionService;

import java.util.List;

public class FunctionServiceBL {

    private FunctionService functionService = new MemoryFunctionService();


    public List<Function> getFunctions() {
        return (List<Function>) functionService.getAllElements();
    }
}
