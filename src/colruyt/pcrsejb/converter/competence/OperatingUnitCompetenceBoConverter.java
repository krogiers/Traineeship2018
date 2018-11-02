package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.OperatingUnitCompetenceBo;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;

public class OperatingUnitCompetenceBoConverter implements CompetenceBoConverter<OperatingUnitCompetenceBo> {
    @Override
    public Competence convertTo(OperatingUnitCompetenceBo from) {
        return new OperatingUnitCompetence(from.getCompetenceID(), from.getName());
    }
}
