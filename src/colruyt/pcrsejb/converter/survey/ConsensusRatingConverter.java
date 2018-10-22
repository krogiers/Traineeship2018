package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusRatingBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.ConsensusRating;
import colruyt.pcrsejb.entity.survey.Rating;

import java.util.List;
import java.util.stream.Collectors;

public class ConsensusRatingConverter implements GenericConverter<ConsensusRatingBo,ConsensusRating> {

    @Override
    public ConsensusRatingBo convertTo(ConsensusRating from) {
        return new ConsensusRatingBo(from.getLevel(),from.isEnergy(),from.getCompetence(),from.getComment());
    }



}