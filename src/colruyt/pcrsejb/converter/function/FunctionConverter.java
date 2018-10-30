package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.FunctionCompetenceBo;
import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.BehavioralCompetenceConverter;
import colruyt.pcrsejb.converter.role.RoleConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.DomainCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class FunctionConverter implements GenericConverter<FunctionBo,Function> {


    @Override
    public FunctionBo convertTo(Function from) {
        return new FunctionBo(from.getTitle(),getRoleBoHashSet(from.getRoleSet()),getFunctionCompetenceBoHashSet(from.getFunctionCompetenceSet()));
    }

    private HashSet<RoleBo> getRoleBoHashSet(Set<Role> roles){
        HashSet<RoleBo> roleBoHashSet = new HashSet<>();
        RoleConverter conv = new RoleConverter();
        for (Role role : roles){
            roleBoHashSet.add(conv.convertTo(role));
        }
        return roleBoHashSet;
    }

    private HashSet<FunctionCompetenceBo> getFunctionCompetenceBoHashSet(Set<FunctionCompetence> competences){
        HashSet<FunctionCompetenceBo> functionCompetenceBoHashSet = new HashSet<>();
        for (FunctionCompetence functionCompetence : competences){
            if (functionCompetence instanceof BehavioralCompetence){
                BehavioralCompetenceConverter conv = new BehavioralCompetenceConverter();
                functionCompetenceBoHashSet.add((FunctionCompetenceBo) conv.convertTo((BehavioralCompetence) functionCompetence));
            } else if (functionCompetence instanceof DomainCompetence) {
                // not implemented yet
            } else if (functionCompetence instanceof OperatingUnitCompetence) {
                // not  implemented yet
            }
        }
        return functionCompetenceBoHashSet;
    }
}
