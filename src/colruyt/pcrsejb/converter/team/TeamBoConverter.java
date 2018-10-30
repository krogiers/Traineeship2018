package colruyt.pcrsejb.converter.team;

import java.util.HashSet;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.bo.privileges.AdminPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.DirectorPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.FunctionResponsiblePrivilegeBo;
import colruyt.pcrsejb.bo.privileges.PrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamManagerPrivilegeBo;
import colruyt.pcrsejb.bo.privileges.TeamMemberPrivilegeBo;
import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.enrolment.EnrolmentBoConverter;
import colruyt.pcrsejb.converter.enrolment.EnrolmentConverter;
import colruyt.pcrsejb.entity.enrollment.Enrollment;
import colruyt.pcrsejb.entity.privileges.AdminPrivilege;
import colruyt.pcrsejb.entity.privileges.DirectorPrivilege;
import colruyt.pcrsejb.entity.privileges.FunctionResponsiblePrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.team.Team;

public class TeamBoConverter implements GenericConverter<Team, TeamBo>{

	EnrolmentBoConverter enrolmentBoConverter = new EnrolmentBoConverter();
	
	@Override
	public Team convertTo(TeamBo from) {
		Team team = new Team();
		HashSet<Enrollment> enrolmentsHashSet = new HashSet<>();
		for (EnrolmentBo e : from.getEnrolmentsBoHashSet())
		{
			enrolmentsHashSet.add(enrolmentBoConverter.convertTo(e));
		}
		team.setEnrolmentsHashSet(enrolmentsHashSet);
		team.setName(from.getName());
		return team;
	}
	


}
