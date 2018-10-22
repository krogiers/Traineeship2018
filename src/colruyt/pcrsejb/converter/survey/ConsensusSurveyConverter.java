package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusSurveyBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;

import java.util.List;
import java.util.stream.Collectors;

public class ConsensusSurveyConverter extends SurveyConverter<ConsensusSurvey> {


    // Consensus Rating ?? geen enforcement
    @Override
    public SurveyBo convertTo(ConsensusSurvey from) {
        return new ConsensusSurveyBo(from.getDateCompleted(),this.convertRatings(from.getRatingList()));
    }



}
