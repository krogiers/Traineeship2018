package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.DomainCompetenceBo;
import colruyt.pcrsejb.bo.competence.FunctionCompetenceBo;
import colruyt.pcrsejb.bo.competence.OperatingUnitCompetenceBo;
import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceBoConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceConverter;
import colruyt.pcrsejb.converter.role.RoleBoConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.DomainCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;
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

        for(FunctionCompetenceBo functionCompetenceBo: functionCompetenceBoSet) {
            if (functionCompetenceBo instanceof BehavioralCompetenceBo){
                BehavioralCompetenceBoConverter conv = new BehavioralCompetenceBoConverter();
                functionCompetenceHashSet.add((FunctionCompetence) conv.convertTo((BehavioralCompetenceBo) functionCompetenceBo));
            } else if (functionCompetenceBo instanceof DomainCompetenceBo) {
                // not implemented yet
            } else if (functionCompetenceBo instanceof OperatingUnitCompetenceBo) {
                // not  implemented yet
            }
        }

        return functionCompetenceHashSet;
    }
}
