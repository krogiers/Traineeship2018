package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.RoleCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleConverter implements GenericConverter<RoleBo,Role> {


    @Override
    public RoleBo convertTo(Role from) {
        return new RoleBo(from.getName(), getRoleCompetenceBoList(from.getRoleCompetenceList()));
    }

    private List<RoleCompetenceBo> getRoleCompetenceBoList(List<RoleCompetence> competences){
        List<RoleCompetenceBo> roleCompetenceBos = new ArrayList<>();
        CompetenceConverter conv = new CompetenceConverter();
        for (RoleCompetence roleCompetence : competences) { 
        	roleCompetenceBos.add( (RoleCompetenceBo) conv.convertTo( (Competence) roleCompetence ));
        }
        return roleCompetenceBos;
    }
}
