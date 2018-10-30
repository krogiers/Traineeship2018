package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;
import colruyt.pcrsejb.entity.competence.Competence;

public class BehavioralCompetenceBoConverter implements CompetenceBoConverter<BehavioralCompetenceBo>{
    @Override
    public Competence convertTo(BehavioralCompetenceBo from) {
        return new BehavioralCompetence(from.getCompetenceID(),from.getName(),from.getDescription(),from.getMinLevel(),from.getPossibilityMap());
    }
}
