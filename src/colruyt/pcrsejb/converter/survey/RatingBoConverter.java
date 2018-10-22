package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingBoConverter implements GenericConverter<Rating,RatingBo> {
    @Override
    public Rating convertTo(RatingBo from) {
        return new Rating(from.getLevel(),from.isEnergy(),from.getCompetence());
    }
}
