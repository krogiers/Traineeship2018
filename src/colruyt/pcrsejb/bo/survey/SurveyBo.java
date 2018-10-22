package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.List;

public abstract class SurveyBo {

    private LocalDate dateCompleted;
    private List<RatingBo> ratingBoList;

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public List<RatingBo> getRatingBoList() {
        return ratingBoList;
    }

    public void setRatingBoList(List<RatingBo> ratingBoList) {
        this.ratingBoList = ratingBoList;
    }

    public SurveyBo(LocalDate dateCompleted, List<RatingBo> ratingBoList) {
        this.dateCompleted = dateCompleted;
        this.ratingBoList = ratingBoList;
    }

    public SurveyBo() {
    }
}
