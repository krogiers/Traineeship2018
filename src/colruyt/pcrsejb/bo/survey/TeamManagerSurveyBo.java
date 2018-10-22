package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.List;

public class TeamManagerSurveyBo extends SurveyBo {

    public TeamManagerSurveyBo(LocalDate dateCompleted, List<RatingBo> ratingBoList) {
        super(dateCompleted, ratingBoList);
    }

    public TeamManagerSurveyBo() {
    }
}
