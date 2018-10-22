package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

public abstract class Survey {

    private LocalDate dateCompleted;
    private List<Rating> ratingList;

    public Survey() {
    }

    public Survey(LocalDate dateCompleted, List<Rating> ratingList) {
        this.dateCompleted = dateCompleted;
        this.ratingList = ratingList;
    }

    public LocalDate getDateCompleted() {
        return dateCompleted;
    }

    public void setDateCompleted(LocalDate dateCompleted) {
        this.dateCompleted = dateCompleted;
    }

    public List<Rating> getRatingList() {
        return ratingList;
    }

    public void setRatingList(List<Rating> ratingList) {
        this.ratingList = ratingList;
    }
}
