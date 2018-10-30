package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.entity.competence.CraftCompetence;

public class CraftCompetenceBoConverter implements CompetenceBoConverter<CraftCompetenceBo> {


    @Override
    public CraftCompetence convertTo(CraftCompetenceBo from) {
        return new CraftCompetence(from.getName(),from.getDescription());
    }
}
