package colruyt.pcrsejb.converter.competence;

import colruyt.pcrsejb.bo.competence.CompetenceBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.competence.Competence;

public interface CompetenceBoConverter<T extends CompetenceBo> extends GenericConverter<Competence,T> {
}
