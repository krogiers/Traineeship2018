package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CraftCompetenceBo;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;

public class CraftConpetenceBoConverter implements CompetenceBoConverter<CraftCompetenceBo> {


    @Override
    public Competence convertTo(CraftCompetenceBo from) {
        return new CraftCompetence(from.getName(),from.getDescription());
    }
}
