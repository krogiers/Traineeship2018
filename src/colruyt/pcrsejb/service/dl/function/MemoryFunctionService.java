package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryFunctionService implements FunctionService {

       private static List<Function> functionList = new ArrayList<>();

    @Override
    public Function save(Function element) {

        element.setId(element.getId());
        this.functionList.add(element);
        return element;
    }

    @Override
    public Function getElement(Function function) {
        return this.functionList.get(function.getId());
    }

    @Override
    public Collection<Function> getAllElements() {
        return this.functionList;
    }

    @Override
    public void deleteElement(Function element) {
        this.functionList.remove(element);
    }

    @Override
    public Collection<Function> getAllFunctionNames() {
        // TODO
        return null;
    }
}
