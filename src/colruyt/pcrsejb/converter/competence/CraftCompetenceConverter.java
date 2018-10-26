package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.*;
import colruyt.pcrsejb.entity.competence.*;

public class CraftCompetenceConverter implements CompetenceConverter<CraftCompetence> {

    @Override
    public CraftCompetenceBo convertTo(CraftCompetence from) {
        return new CraftCompetenceBo(from.getName(),from.getDescription());
    }
}
