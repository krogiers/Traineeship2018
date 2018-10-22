package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.role.Role;

public class RoleConverter implements GenericConverter<RoleBo,Role> {


    @Override
    public RoleBo convertTo(Role from) {
        return new RoleBo(from.getName(),from.getRoleCompetenceList());
    }
}
