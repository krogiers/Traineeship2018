package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.DomainCompetenceBo;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.DomainCompetence;

public class DomainCompetenceBoConverter implements CompetenceBoConverter<DomainCompetenceBo>{

	@Override
	public Competence convertTo(DomainCompetenceBo from) {
		Competence competence = new DomainCompetence(from.getCompetenceID(), from.getName());
		return competence;
	}

}
