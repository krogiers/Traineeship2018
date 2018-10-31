package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.Collection;

public interface FunctionService extends GenericCrudService<Function,Integer> {

    Collection<Function> getAllFunctionNames();

}
