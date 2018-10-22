package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.TeamMemberSurveyBo;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.TeamMemberSurvey;

public class TeamMemberSurveyBoConverter extends SurveyBoConverter<TeamMemberSurveyBo> {


    @Override
    public Survey convertTo(TeamMemberSurveyBo from) {
        return new TeamMemberSurvey(from.getDateCompleted(),this.convertRatings(from.getRatingBoList()));
    }
}
