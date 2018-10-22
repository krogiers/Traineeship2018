package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusSurveyBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;
import colruyt.pcrsejb.entity.survey.Survey;

public class ConsensusSurveyConverter implements SurveyConverter<ConsensusSurvey> {


    @Override
    public SurveyBo convertTo(ConsensusSurvey from) {
        return new ConsensusSurveyBo();
    }
}
