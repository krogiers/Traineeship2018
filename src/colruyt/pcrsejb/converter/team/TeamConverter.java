package colruyt.pcrsejb.converter.team;

import colruyt.pcrsejb.bo.enrolment.EnrolmentBo;
import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.enrolment.EnrolmentConverter;
import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;

import java.util.HashSet;

public class TeamConverter implements GenericConverter<TeamBo, Team>{

	EnrolmentConverter enrolmentConverter = new EnrolmentConverter();
	

	@Override
	public TeamBo convertTo(Team from) {
		TeamBo teamBo = new TeamBo();
		teamBo.setName(from.getName());
		teamBo.setId(from.getTeamID());
		HashSet<EnrolmentBo> enrolmentsBoHashSet = new HashSet<>();
		for (Enrolment e : from.getEnrolmentsHashSet())
		{
			enrolmentsBoHashSet.add(enrolmentConverter.convertTo(e));
		}
		teamBo.setEnrolmentsBoHashSet(enrolmentsBoHashSet);
		return teamBo;
	}
	
	

}
