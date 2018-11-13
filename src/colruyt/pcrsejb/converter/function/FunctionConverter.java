package colruyt.pcrsejb.converter.function;

import colruyt.pcrsejb.bo.competence.FunctionCompetenceBo;
import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.operatingunit.OperatingUnitBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.converter.operatingunit.OperatingUnitConverter;
import colruyt.pcrsejb.converter.role.RoleConverter;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class FunctionConverter implements GenericConverter<FunctionBo, Function> {

    private OperatingUnitConverter operatingUnitConverter = new OperatingUnitConverter();

    @Override
    public FunctionBo convertTo(Function from) {
        return new FunctionBo(from.getId(), from.getTitle(), getRoleBoHashSet(from.getRoleSet()), getFunctionCompetenceBoHashSet(from.getFunctionCompetenceSet()), getOperatingUnit(from.getOperatingUnit()));
    }

    private HashSet<RoleBo> getRoleBoHashSet(Set<Role> roles) {
        HashSet<RoleBo> roleBoHashSet = new HashSet<>();
        RoleConverter conv = new RoleConverter();
        for (Role role : roles) {
            roleBoHashSet.add(conv.convertTo(role));
        }
        return roleBoHashSet;
    }

    private HashSet<FunctionCompetenceBo> getFunctionCompetenceBoHashSet(Set<FunctionCompetence> competences) {
        HashSet<FunctionCompetenceBo> functionCompetenceBoHashSet = new HashSet<>();
        CompetenceConverter conv = new CompetenceConverter();
        for (FunctionCompetence functionCompetence : competences) {
            functionCompetenceBoHashSet.add((FunctionCompetenceBo) conv.convertTo((Competence) functionCompetence));
        }
        return functionCompetenceBoHashSet;
    }

    private OperatingUnitBo getOperatingUnit(OperatingUnit ou) {
        OperatingUnitConverter converter = new OperatingUnitConverter();
        return converter.convertTo(ou);
    }

}
