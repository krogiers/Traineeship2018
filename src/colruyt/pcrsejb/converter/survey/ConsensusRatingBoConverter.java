package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusRatingBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.ConsensusRating;
import colruyt.pcrsejb.entity.survey.Rating;

public class ConsensusRatingBoConverter implements GenericConverter<ConsensusRating,ConsensusRatingBo> {


    @Override
    public ConsensusRating convertTo(ConsensusRatingBo from) {
        return new ConsensusRating(from.getLevel(),from.isEnergy(),from.getCompetence(),from.getComment());
    }

}
