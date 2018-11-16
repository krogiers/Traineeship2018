package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.List;

public class SurveyBo {

    private LocalDate dateCompleted;
    private List<RatingBo> ratingBoList;
    private SurveyKindBo kind;
    
    
    
    

    public SurveyKindBo getKind() {
		return kind;
	}

	public void setKind(SurveyKindBo kind) {
		this.kind = kind;
	}

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

    public SurveyBo(LocalDate dateCompleted, List<RatingBo> ratingBoList,SurveyKindBo bo) {
        this.dateCompleted = dateCompleted;
        this.ratingBoList = ratingBoList;
        this.setKind(bo);
    }

    public SurveyBo() {
    }
}
