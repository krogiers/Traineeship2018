package colruyt.pcrsejb.converter.role;

import colruyt.pcrsejb.bo.role.RoleBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.role.Role;

public class RoleBoConverter implements GenericConverter<Role,RoleBo> {


    @Override
    public Role convertTo(RoleBo from) {
        return new Role(from.getName(),from.getRoleCompetenceList());
    }
}
