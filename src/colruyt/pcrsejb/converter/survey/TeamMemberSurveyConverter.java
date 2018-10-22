package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.TeamMemberSurveyBo;
import colruyt.pcrsejb.entity.survey.TeamMemberSurvey;

public class TeamMemberSurveyConverter extends SurveyConverter<TeamMemberSurvey> {


    @Override
    public SurveyBo convertTo(TeamMemberSurvey from) {
        return new TeamMemberSurveyBo(from.getDateCompleted(),this.convertRatings(from.getRatingList()));
    }
}
