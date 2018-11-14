package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceBoConverter;
import colruyt.pcrsejb.entity.competence.RoleCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleBoConverter implements GenericConverter<Role,RoleBo> {


    @Override
    public Role convertTo(RoleBo from) {

        return new Role(from.getId(), from.getName(), getRoleComptenceList(from.getRoleCompetenceBoList()));
    }

    private List<RoleCompetence> getRoleComptenceList(List<RoleCompetenceBo> competences) {
        List<RoleCompetence> roleCompetenceList = new ArrayList<>();
        if(competences != null) {
            CompetenceBoConverter conv = new CompetenceBoConverter();
            for (RoleCompetenceBo roleCompetenceBo : competences) {
                roleCompetenceList.add((RoleCompetence) conv.convertTo((CompetenceBo) roleCompetenceBo));
            }
        }
        return roleCompetenceList;
    }
}
