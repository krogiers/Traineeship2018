package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.*;
import colruyt.pcrsejb.entity.competence.*;

public class CraftCompetenceConverter implements CompetenceConverter<CraftCompetence> {

    @Override
    public CompetenceBo convertTo(CraftCompetence from) {
        return new CraftCompetenceBo(from.getCompetenceID(),from.getName(),from.getDescription());
    }
}
