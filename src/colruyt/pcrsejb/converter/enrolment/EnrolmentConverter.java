package colruyt.pcrsejb.converter.enrolment;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeBoConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.enrolment.Enrolment;

public class EnrolmentConverter implements GenericConverter<EnrolmentBo, Enrolment> {
	private UserPrivilegeConverter userPrivilegeConverter = new UserPrivilegeConverter();
	private UserConverter userConverter = new UserConverter();

	@Override
	public EnrolmentBo convertTo(Enrolment from) {
		EnrolmentBo bo = new EnrolmentBo();
		bo.setId(from.getEnrolmentID());
		bo.setActive(from.isActive());
		bo.setPrivilegeBo(userPrivilegeConverter.convertTo(from.getPrivilege()));
		bo.setUserBo(userConverter.convertTo(from.getUser()));
		return bo;
	}

}
