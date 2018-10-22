package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

public class TeamMemberSurvey extends Survey {

    public TeamMemberSurvey() {
        super();
    }

    public TeamMemberSurvey(LocalDate dateCompleted, List<Rating> ratingList) {
        super(dateCompleted, ratingList);
    }
}
