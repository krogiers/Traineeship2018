package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;

public class FunctionBoConverter implements GenericConverter<Function,FunctionBo> {


    @Override
    public Function convertTo(FunctionBo from) {
        return new Function(from.getTitle(),(HashSet<Role>)from.getRoleBoSet(),(HashSet<FunctionCompetence>)from.getFunctionCompetenceBoSet());
    }
}
