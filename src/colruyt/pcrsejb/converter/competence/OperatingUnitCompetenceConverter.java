package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;
import colruyt.pcrsejb.bo.competence.OperatingUnitCompetenceBo;

public class OperatingUnitCompetenceConverter implements CompetenceBoConverter<OperatingUnitCompetenceBo> {
    @Override
    public Competence convertTo(OperatingUnitCompetenceBo from) {
        return new OperatingUnitCompetence(from.getCompetenceID(), from.getName());
    }
}
