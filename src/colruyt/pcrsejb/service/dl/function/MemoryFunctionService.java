package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryFunctionService implements FunctionService {

       private List<Function> functionList = new ArrayList<>();

    @Override
    public Function addElement(Function element) {
        this.functionList.add(element);
        return element;
    }

    @Override
    public Function getElement(Integer index) {
        return this.functionList.get(index);
    }

    @Override
    public Collection<Function> getAllElements() {
        return this.functionList;
    }

    @Override
    public void deleteElement(Function element) {
        this.functionList.remove(element);
    }
}
