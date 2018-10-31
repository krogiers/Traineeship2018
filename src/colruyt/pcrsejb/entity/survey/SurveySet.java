package colruyt.pcrsejb.entity.survey;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.Set;

public class SurveySet implements Comparable<SurveySet>{

    private long surveySetID;
    private LocalDate surveyYear;
    private Set<Survey> surveySet;

    public SurveySet(long surveySetID, LocalDate surveyYear, Set<Survey> surveySet) {
        this.surveySetID = surveySetID;
        this.surveyYear = surveyYear;
        this.surveySet = surveySet;
    }

    @Override
    public int compareTo(SurveySet o) {
        throw new NotImplementedException();
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

    public Set<Survey> getSurveySet() {
        return surveySet;
    }

    public void setSurveySet(Set<Survey> surveySet) {
        this.surveySet = surveySet;
    }
}
