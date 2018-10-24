package colruyt.pcrsejb.converter.privilege;

import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.privileges.Privilege;

public interface PrivilegeConverter<T extends PrivilegeBo>  extends GenericConverter<Privilege,T> {
}
