package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingConverter implements GenericConverter<RatingBo,Rating> {

    @Override
    public RatingBo convertTo(Rating from) {
        RatingBo ratingBo;
        Competence competence = from.getCompetence();
            CompetenceConverter conv = new CompetenceConverter();
            ratingBo = new RatingBo(from.getLevel(), from.isEnergy(), conv.convertTo(competence));
        return ratingBo;
    }
}
