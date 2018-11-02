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

public class CompetenceConverter implements GenericConverter<CompetenceBo,Competence> {

	@Override
	public CompetenceBo convertTo(Competence from) {
		
		CompetenceBo competenceBo = null;
        switch(determineInstance(from)){
        case "BehavioralCompetence" : competenceBo = new BehavioralCompetenceBo(from.getCompetenceID(), from.getName(), ( (BehavioralCompetence) from).getDescription(), ( (BehavioralCompetence) from).getMinLevel(), ((BehavioralCompetence) from).getPossibilityMap() ); break;
        case "CraftCompetence" : competenceBo = new CraftCompetenceBo(from.getCompetenceID(), from.getName(), ( (CraftCompetence) from).getDescription(), ((CraftCompetence) from).getPossibilityMap() ); break;
        case "DomainCompetence" : competenceBo = new DomainCompetenceBo(from.getCompetenceID(), from.getName()); break;
        case "OperatingUnitCompetence" : competenceBo = new OperatingUnitCompetenceBo(from.getCompetenceID(), from.getName()); break;
        }
        return competenceBo;   
	}

	private String determineInstance(Competence from) {
		return from.getClass().getSimpleName();
	}

}
