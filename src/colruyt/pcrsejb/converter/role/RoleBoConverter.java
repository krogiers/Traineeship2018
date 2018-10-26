package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.RoleCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.ArrayList;
import java.util.List;

public class RoleBoConverter implements GenericConverter<Role,RoleBo> {


    @Override
    public Role convertTo(RoleBo from) {
        return new Role(from.getName(), getRoleComptenceList(from.getRoleCompetenceBoList()));
    }

    private List<RoleCompetence> getRoleComptenceList(List<RoleCompetenceBo> competences) {
        List<RoleCompetence> roleCompetenceList = new ArrayList<>();
        for (RoleCompetenceBo roleCompetenceBo : competences) {
            if (roleCompetenceBo instanceof CraftCompetenceBo) {
                CraftCompetenceConverter conv = new CraftCompetenceConverter();
                roleCompetenceList.add((RoleCompetence) conv.convertTo( (CraftCompetence) roleCompetenceBo ));
            }
        }
        return roleCompetenceList;
    }
}
