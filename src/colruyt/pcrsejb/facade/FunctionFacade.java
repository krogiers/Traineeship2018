package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.bl.FunctionServiceBL;

import java.util.ArrayList;
import java.util.List;

public class FunctionFacade {

    private FunctionServiceBL functionServiceBL = new FunctionServiceBL();
    private FunctionConverter functionConverter = new FunctionConverter();
    private FunctionBoConverter functionBoConverter = new FunctionBoConverter();


    public List<FunctionBo> getAllFunctionNames() {
        List<FunctionBo> functionBoList = new ArrayList<>();

        for(Function function : functionServiceBL.getAllFunctionNames()) {
            functionBoList.add(functionConverter.convertTo(function));
        }
        return functionBoList;
    }
}
