package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.List;

public class TeamMemberSurveyBo extends SurveyBo {

    public TeamMemberSurveyBo(LocalDate dateCompleted, List<RatingBo> ratingBoList) {
        super(dateCompleted, ratingBoList);
    }

    public TeamMemberSurveyBo() {
    }
}
