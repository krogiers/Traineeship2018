package colruyt.pcrsejb.converter.team;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.enrolment.EnrolmentBoConverter;
import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;

import java.util.HashSet;

public class TeamBoConverter implements GenericConverter<Team, TeamBo>{

	EnrolmentBoConverter enrolmentBoConverter = new EnrolmentBoConverter();
	
	@Override
	public Team convertTo(TeamBo from) {
		Team team = new Team();
		team.setTeamID(from.getId());
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
