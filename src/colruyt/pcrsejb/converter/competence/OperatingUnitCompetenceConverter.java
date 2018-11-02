package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.OperatingUnitCompetenceBo;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;

public class OperatingUnitCompetenceConverter implements CompetenceConverter<OperatingUnitCompetence> {
    @Override
    public CompetenceBo convertTo(OperatingUnitCompetence from) {
        return new OperatingUnitCompetenceBo(from.getCompetenceID(), from.getName());
    }
}
