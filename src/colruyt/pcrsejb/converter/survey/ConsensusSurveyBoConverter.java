package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusSurveyBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;
import colruyt.pcrsejb.entity.survey.Survey;

public class ConsensusSurveyBoConverter implements SurveyBoConverter<ConsensusSurveyBo> {


    @Override
    public Survey convertTo(ConsensusSurveyBo from) {
        return new ConsensusSurvey();
    }
}