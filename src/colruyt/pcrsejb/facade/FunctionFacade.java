package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.service.bl.FunctionServiceBL;
import colruyt.pcrsejb.service.dl.function.FunctionService;
import colruyt.pcrsejb.service.dl.function.MemoryFunctionService;

public class FunctionFacade {

    private FunctionServiceBL functionServiceBL = new FunctionServiceBL();
    private FunctionConverter functionConverter = new FunctionConverter();
    private FunctionBoConverter functionBoConverter = new FunctionBoConverter();

}
