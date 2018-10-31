package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.DomainCompetenceBo;
import colruyt.pcrsejb.entity.competence.DomainCompetence;

public class DomainCompetenceConverter implements CompetenceConverter<DomainCompetence>{

	@Override
	public CompetenceBo convertTo(DomainCompetence from) {
		CompetenceBo competence = new DomainCompetenceBo(from.getCompetenceID(), from.getName());
		return competence;
	}

}
