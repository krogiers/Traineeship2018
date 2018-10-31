package colruyt.pcrsejb.entity.survey;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.Set;

public class SurveySet implements Comparable<SurveySet>{

    private int id;
    private LocalDate surveyYear;
    private Set<Survey> surveySet;

    public SurveySet() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    @Override
    public int compareTo(SurveySet o){

       return this.getSurveyYear().compareTo(o.getSurveyYear());


    }
}
