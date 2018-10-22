package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.entity.competence.CraftCompetence;

public class CraftCompetenceConverter implements CompetenceConverter<CraftCompetence> {

    @Override
    public CompetenceBo convertTo(CraftCompetence from) {
        return new CraftCompetenceBo(from.getName(),from.getDescription());
    }
}
