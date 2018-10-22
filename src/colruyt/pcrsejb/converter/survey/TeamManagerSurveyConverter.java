package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.TeamManagerSurveyBo;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.TeamManagerSurvey;

public class TeamManagerSurveyConverter extends SurveyConverter<TeamManagerSurvey> {



    @Override
    public SurveyBo convertTo(TeamManagerSurvey from) {
        return new TeamManagerSurveyBo(from.getDateCompleted(),this.convertRatings(from.getRatingList()));
    }
}
