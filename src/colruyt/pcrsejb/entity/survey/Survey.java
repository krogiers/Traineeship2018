package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

public abstract class Survey {

    private LocalDate dateCompleted;
    private List<Rating> ratingList;
}
