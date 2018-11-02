package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.bo.competence.DomainCompetenceBo;
import colruyt.pcrsejb.bo.competence.OperatingUnitCompetenceBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.DomainCompetence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;

public class CompetenceBoConverter<T extends CompetenceBo> implements GenericConverter<Competence,T> {

	@Override
	public Competence convertTo(T from) {
		
		Competence competence = null;
        switch(determineInstance(from)){
        case "BehavioralCompetenceBo" : competence = new BehavioralCompetence(from.getCompetenceID(), from.getName(), ( (BehavioralCompetenceBo) from).getDescription(), ( (BehavioralCompetenceBo) from).getMinLevel(), ((BehavioralCompetenceBo) from).getPossibilityMap() ); break;
        case "CraftCompetenceBo" : competence = new CraftCompetence(from.getCompetenceID(), from.getName(), ( (CraftCompetenceBo) from).getDescription(), ((CraftCompetenceBo) from).getPossibilityMap() ); break;
        case "DomainCompetenceBo" : competence = new DomainCompetence(from.getCompetenceID(), from.getName()); break;
        case "OperatingUnitCompetenceBo" : competence = new OperatingUnitCompetence(from.getCompetenceID(), from.getName()); break;
        }
        return competence;   
	}

	private String determineInstance(T from) {
		return from.getClass().getSimpleName();
	}

}
