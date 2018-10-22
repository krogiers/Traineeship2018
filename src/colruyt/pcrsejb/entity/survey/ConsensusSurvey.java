package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

public class ConsensusSurvey extends Survey {

    public ConsensusSurvey() {
    }

    public ConsensusSurvey(LocalDate dateCompleted, List<Rating> ratingList) {
        super(dateCompleted, ratingList);
    }
}
