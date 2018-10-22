package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.TeamManagerSurveyBo;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.TeamManagerSurvey;

public class TeamManagerSurveyBoConverter implements SurveyBoConverter<TeamManagerSurveyBo> {
    @Override
    public Survey convertTo(TeamManagerSurveyBo from) {
        return new TeamManagerSurvey();
    }
}
