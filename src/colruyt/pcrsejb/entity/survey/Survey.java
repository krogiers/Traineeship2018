package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.List;

//import javax.persistence.Entity;


//@Entity
public class Survey {

    private LocalDate dateCompleted;
    private List<Rating> ratingList;
    private int id;
    private SurveyKind surveyKind;
    
    
    
    
    
    
    public SurveyKind getSurveyKind() {
		return surveyKind;
	}

	public void setSurveyKind(SurveyKind surveyKind) {
		this.surveyKind = surveyKind;
	}

	public Survey() {
    }

    public Survey(LocalDate dateCompleted, List<Rating> ratingList,SurveyKind kind) {
        this.dateCompleted = dateCompleted;
        this.ratingList = ratingList;
        this.surveyKind = kind;
        
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
