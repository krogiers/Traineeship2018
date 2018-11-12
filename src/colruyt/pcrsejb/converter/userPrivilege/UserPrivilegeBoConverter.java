package colruyt.pcrsejb.converter.userPrivilege;

import colruyt.pcrsejb.bo.userPrivilege.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionBoConverter;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;

public class UserPrivilegeBoConverter implements GenericConverter<UserPrivilege,UserPrivilegeBo> {

	FunctionBoConverter functionBoConverter = new FunctionBoConverter();

    @Override
    public UserPrivilege convertTo(UserPrivilegeBo from) {
        UserPrivilege userPrivilege = null;
        PrivilegeTypeBo typeBo = from.getPrivilegeType();
        PrivilegeType type;
        if (typeBo == PrivilegeTypeBo.TEAMMEMBER) {
        	type = PrivilegeType.TEAMMEMBER;
        	userPrivilege = new TeamMemberUserPrivilege(type, from.isActive(), functionBoConverter.convertTo(((FunctionUserPrivilegeBo) from).getFunction()), ((TeamMemberUserPrivilegeBo) from).getStartDateInCurrentFunction());
        }
        else if (typeBo == PrivilegeTypeBo.TEAMMANAGER) {
        	type = PrivilegeType.TEAMMANAGER;
        	userPrivilege = new UserPrivilege(type, from.isActive());
        }
        else if (typeBo == PrivilegeTypeBo.FUNCTIONRESPONSIBLE) {
        	type = PrivilegeType.FUNCTIONRESPONSIBLE;
        	userPrivilege = new FunctionResponsibleUserPrivilege(type, from.isActive(), functionBoConverter.convertTo(((FunctionUserPrivilegeBo) from).getFunction()), ((FunctionResponsibleUserPrivilegeBo) from).getCountry());
        }
        else if (typeBo == PrivilegeTypeBo.DIRECTOR) {
        	type = PrivilegeType.DIRECTOR;
        	userPrivilege = new UserPrivilege(type, from.isActive());
        }
        else if (typeBo == PrivilegeTypeBo.ADMINISTRATOR) {
        	type = PrivilegeType.ADMINISTRATOR;
        	userPrivilege = new UserPrivilege(type, from.isActive());
        }
        return userPrivilege;
    }
}
