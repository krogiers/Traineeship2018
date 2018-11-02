package colruyt.pcrsejb.converter.DONOTUSEANYMOREprivilege;

import colruyt.pcrsejb.bo.privileges.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.entity.DONOTUSEANYMOREprivileges.*;

public class PrivilegeBoConverter implements GenericConverter<Privilege,PrivilegeBo> {


    @Override
    public Privilege convertTo(PrivilegeBo from) {
        Privilege privilege = null;
        if (from instanceof AdminPrivilegeBo) {
            privilege = new AdminPrivilege();
        } else if (from instanceof DirectorPrivilegeBo) {
            privilege = new DirectorPrivilege();
        } else if (from instanceof FunctionResponsiblePrivilegeBo) {
            FunctionBoConverter conv = new FunctionBoConverter();
            privilege = new FunctionResponsiblePrivilege(
                    ((FunctionResponsiblePrivilegeBo) from).getCountry(),
                    conv.convertTo(((FunctionResponsiblePrivilegeBo) from).getFunctionBo()));
        } else if (from instanceof TeamManagerPrivilegeBo) {
            privilege = new TeamManagerPrivilege();
        } else if (from instanceof TeamMemberPrivilegeBo) {
            privilege = new TeamMemberPrivilege(((TeamMemberPrivilegeBo) from).getStartDateInCurrentFunction());
        }
        return privilege;
    }
}
