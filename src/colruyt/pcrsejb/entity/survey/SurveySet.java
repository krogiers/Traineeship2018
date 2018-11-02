package colruyt.pcrsejb.entity.survey;

import java.time.LocalDate;
import java.util.HashMap;

public class SurveySet implements Comparable<SurveySet>{

    private long surveySetID;
    private LocalDate surveyYear;
    private HashMap<SurveyKind,Survey> surveySet;

    public SurveySet(long surveySetID, LocalDate surveyYear, HashMap<SurveyKind,Survey> surveySet) {
        this.surveySetID = surveySetID;
        this.surveyYear = surveyYear;
        this.surveySet = surveySet;
    }

    public SurveySet() {
    	
    }

    @Override
    public int compareTo(SurveySet o) {
        return this.surveyYear.compareTo(o.getSurveyYear());
    }

    public long getSurveySetID() {
        return surveySetID;
    }

    public void setSurveySetID(long surveySetID) {
        this.surveySetID = surveySetID;
    }

    public LocalDate getSurveyYear() {
        return surveyYear;
    }

    public void setSurveyYear(LocalDate surveyYear) {
        this.surveyYear = surveyYear;
    }

    public HashMap<SurveyKind, Survey> getSurveySet() {
        return surveySet;
    }

    public void setSurveySet(HashMap<SurveyKind, Survey> surveySet) {
        this.surveySet = surveySet;
    }
}
