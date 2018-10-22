package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;

public class RatingConverter implements GenericConverter<RatingBo,Rating> {
    @Override
    public RatingBo convertTo(Rating from) {
        return new RatingBo(from.getLevel(),from.isEnergy(),from.getCompetence());
    }
}
