package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.ConsensusSurveyBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.entity.survey.ConsensusSurvey;

public class ConsensusSurveyConverter extends SurveyConverter<ConsensusSurvey> {


    // Consensus Rating ?? geen enforcement
    @Override
    public SurveyBo convertTo(ConsensusSurvey from) {
        return new ConsensusSurveyBo(from.getDateCompleted(),this.convertRatings(from.getRatingList()));
    }



}
