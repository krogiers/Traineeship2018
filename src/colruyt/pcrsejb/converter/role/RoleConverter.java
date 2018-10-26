package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CraftCompetenceConverter;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
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
        for (RoleCompetence roleCompetence : competences) {
            if (roleCompetence instanceof CraftCompetence) {
                CraftCompetenceConverter conv = new CraftCompetenceConverter();
                roleCompetenceBos.add((RoleCompetenceBo) conv.convertTo( (CraftCompetence) roleCompetence ));
            }
        }
        return roleCompetenceBos;
    }
}
