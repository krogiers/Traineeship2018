package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

public class TeamManagerSurvey extends Survey {

    public TeamManagerSurvey() {
        super();
    }

    public TeamManagerSurvey(LocalDate dateCompleted, List<Rating> ratingList) {
        super(dateCompleted, ratingList);
    }
}
