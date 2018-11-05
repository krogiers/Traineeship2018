package colruyt.pcrsejb.converter.userPrivilege;

import colruyt.pcrsejb.bo.privileges.*;
import colruyt.pcrsejb.bo.userPrivilege.FunctionResponsibleUserPrivilegeBo;
import colruyt.pcrsejb.bo.userPrivilege.FunctionUserPrivilegeBo;
import colruyt.pcrsejb.bo.userPrivilege.PrivilegeTypeBo;
import colruyt.pcrsejb.bo.userPrivilege.TeamMemberUserPrivilegeBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.FunctionUserPrivilege;

public class UserPrivilegeConverter implements GenericConverter<UserPrivilegeBo, UserPrivilege> {

	FunctionConverter functionConverter = new FunctionConverter();

    @Override
    public UserPrivilegeBo convertTo(UserPrivilege from) {
        UserPrivilegeBo userPrivilegeBo = null;
        PrivilegeType type = from.getPrivilegeType();
        PrivilegeTypeBo typeBo = null;
        if (type == PrivilegeType.TEAMMEMBER) {
        	typeBo = PrivilegeTypeBo.TEAMMEMBER;
        	userPrivilegeBo = new TeamMemberUserPrivilegeBo(typeBo, from.isActive(), functionConverter.convertTo(((FunctionUserPrivilege) from).getFunction()), ((TeamMemberUserPrivilege) from).getStartDateInCurrentFunction());
        }
        else if (type == PrivilegeType.TEAMMANAGER) {
        	typeBo = PrivilegeTypeBo.TEAMMANAGER;
        	userPrivilegeBo = new UserPrivilegeBo(typeBo, from.isActive());
        }
        else if (type == PrivilegeType.FUNCTIONRESPONSIBLE) {
        	typeBo = PrivilegeTypeBo.FUNCTIONRESPONSIBLE;
        	userPrivilegeBo = new FunctionResponsibleUserPrivilegeBo(typeBo, from.isActive(), functionConverter.convertTo(((FunctionUserPrivilege) from).getFunction()), ((FunctionResponsibleUserPrivilege) from).getCountry());
        }
        else if (type == PrivilegeType.DIRECTOR) {
        	typeBo = PrivilegeTypeBo.DIRECTOR;
        	userPrivilegeBo = new UserPrivilegeBo(typeBo, from.isActive());
        }
        else if (type == PrivilegeType.ADMINISTRATOR) {
        	typeBo = PrivilegeTypeBo.ADMINISTRATOR;
        	userPrivilegeBo = new UserPrivilegeBo(typeBo, from.isActive());
        }
        return userPrivilegeBo;
    }
}
