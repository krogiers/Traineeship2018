package colruyt.pcrsejb.converter.privilege;

import colruyt.pcrsejb.bo.privileges.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.entity.privileges.*;

public class PrivilegeConverter implements GenericConverter<PrivilegeBo, Privilege> {


    @Override
    public PrivilegeBo convertTo(Privilege from) {
        PrivilegeBo privilegeBo = null;
        if (from instanceof AdminPrivilege) {
            privilegeBo = new AdminPrivilegeBo();
        } else if (from instanceof DirectorPrivilege) {
            privilegeBo = new DirectorPrivilegeBo();
        } else if (from instanceof FunctionResponsiblePrivilege) {
            FunctionConverter conv = new FunctionConverter();
            privilegeBo = new FunctionResponsiblePrivilegeBo(
                    ((FunctionResponsiblePrivilege) from).getCountry(),
                    conv.convertTo(((FunctionResponsiblePrivilege) from).getFunction()));
        } else if (from instanceof TeamManagerPrivilege) {
            privilegeBo = new TeamManagerPrivilegeBo();
        } else if (from instanceof TeamMemberPrivilege) {
            privilegeBo = new TeamMemberPrivilegeBo(((TeamMemberPrivilege) from).getStartDateInCurrentFunction());
        }
        return privilegeBo;
    }
}
