package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.List;

public class ConsensusSurveyBo extends SurveyBo {

    public ConsensusSurveyBo(LocalDate dateCompleted, List<RatingBo> ratingBoList) {
        super(dateCompleted, ratingBoList);
    }

    public ConsensusSurveyBo() {
    }


}
