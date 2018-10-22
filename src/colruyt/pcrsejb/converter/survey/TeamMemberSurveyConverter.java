package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.TeamMemberSurveyBo;
import colruyt.pcrsejb.entity.survey.TeamMemberSurvey;

public class TeamMemberSurveyConverter implements SurveyConverter<TeamMemberSurvey> {

    //RatingBoConverter Nodig !!!!!!!!!
    @Override
    public SurveyBo convertTo(TeamMemberSurvey from) {
        return new TeamMemberSurveyBo();
    }
}
