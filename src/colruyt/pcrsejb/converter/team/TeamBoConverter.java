package colruyt.pcrsejb.converter.team;

import java.util.HashSet;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.enrolment.EnrolmentBoConverter;
import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;

public class TeamBoConverter implements GenericConverter<Team, TeamBo>{

	EnrolmentBoConverter enrolmentBoConverter = new EnrolmentBoConverter();
	
	@Override
	public Team convertTo(TeamBo from) {
		Team team = new Team();
		HashSet<Enrolment> enrolmentsHashSet = new HashSet<>();
		for (EnrolmentBo e : from.getEnrolmentsBoHashSet())
		{
			enrolmentsHashSet.add(enrolmentBoConverter.convertTo(e));
		}
		team.setEnrolmentsHashSet(enrolmentsHashSet);
		team.setName(from.getName());
		return team;
	}
	


}
