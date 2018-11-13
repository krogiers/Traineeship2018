package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.Collection;
import java.util.List;

public interface FunctionService extends GenericCrudService<Function,Integer> {

    List<Function> getAllFunctionNames();

}
