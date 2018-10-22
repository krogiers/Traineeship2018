package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusSurveyBo;
import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;

import java.util.List;
import java.util.stream.Collectors;

public class ConsensusSurveyBoConverter extends SurveyBoConverter<ConsensusSurveyBo> {


    // Consensus Rating ?? geen enforcement
    @Override
    public Survey convertTo(ConsensusSurveyBo from) {

        return new ConsensusSurvey(from.getDateCompleted(),this.convertRatings(from.getRatingBoList()));


    }



}