package colruyt.pcrsejb.converter.enrolment;

import java.util.HashSet;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.bo.privileges.AdminPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.DirectorPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.FunctionResponsiblePrivilegeBo;
import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamManagerPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamMemberPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.enrollment.Enrollment;
import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.DirectorPrivilege;
import colruyt.pcrsejb.entity.privileges.FunctionResponsiblePrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;

public class EnrolmentBoConverter implements GenericConverter<Enrollment, EnrolmentBo>{

	@Override
	public Enrollment convertTo(EnrolmentBo from) {
		// TODO Auto-generated method stub
		return null;
	}

	
}
