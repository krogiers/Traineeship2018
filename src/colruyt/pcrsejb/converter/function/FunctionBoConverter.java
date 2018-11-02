package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.FunctionCompetenceBo;
import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceBoConverter;
import colruyt.pcrsejb.converter.role.RoleBoConverter;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class FunctionBoConverter implements GenericConverter<Function,FunctionBo> {


    @Override
    public Function convertTo(FunctionBo from) {
        return new Function(from.getID(), from.getTitle(), getRoleSet(from.getRoleBoSet()),getFunctionCompetenceSet(from.getFunctionCompetenceBoSet()));
    }

    private HashSet<Role> getRoleSet(Set<RoleBo> roleBoSet){
        HashSet<Role> roleHashSet = new HashSet<>();
        RoleBoConverter conv = new RoleBoConverter();

        for(RoleBo roleBo : roleBoSet) {
            roleHashSet.add(conv.convertTo(roleBo));
        }
        return roleHashSet;
    }

    private HashSet<FunctionCompetence> getFunctionCompetenceSet(Set<FunctionCompetenceBo> functionCompetenceBoSet){
        HashSet<FunctionCompetence> functionCompetenceHashSet = new HashSet<>();
		CompetenceBoConverter competenceBoConverter = new CompetenceBoConverter(); 
        for(FunctionCompetenceBo functionCompetenceBo: functionCompetenceBoSet) {
            functionCompetenceHashSet.add((FunctionCompetence) competenceBoConverter.convertTo((CompetenceBo) functionCompetenceBo));
        }

        return functionCompetenceHashSet;
    }
}
