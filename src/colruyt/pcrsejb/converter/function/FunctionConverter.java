package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;

public class FunctionConverter implements GenericConverter<FunctionBo,Function> {


    @Override
    public FunctionBo convertTo(Function from) {
        return new FunctionBo(from.getTitle(),(HashSet<Role>)from.getRoleSet(),(HashSet<FunctionCompetence>)from.getFunctionCompetenceSet());

    }
}
