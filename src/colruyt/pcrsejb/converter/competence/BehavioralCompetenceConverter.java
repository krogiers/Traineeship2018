package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.BehavioralCompetenceBo;
import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.entity.competence.BehavioralCompetence;

public class BehavioralCompetenceConverter implements CompetenceConverter<BehavioralCompetence> {
    @Override
    public CompetenceBo convertTo(BehavioralCompetence from) {
        return new BehavioralCompetenceBo(from.getCompetenceID(),from.getName(),from.getDescription(),from.getMinLevel(),from.getPossibilityMap());
    }
}
