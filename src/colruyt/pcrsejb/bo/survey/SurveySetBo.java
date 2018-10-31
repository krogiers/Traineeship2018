package colruyt.pcrsejb.bo.survey;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.Set;

public class SurveySetBo implements Comparable<SurveySetBo>{


    private long surveySetID;
    private LocalDate surveyYear;
    private Set<SurveyBo> surveyBoSet;


    public SurveySetBo() {
    }

    public SurveySetBo(LocalDate surveyYear, Set<SurveyBo> surveyBoSet) {
        this.surveyYear = surveyYear;
        this.surveyBoSet = surveyBoSet;
    }

    public SurveySetBo(long surveySetID, LocalDate surveyYear, Set<SurveyBo> surveyBoSet) {
        this.surveySetID = surveySetID;
        this.surveyYear = surveyYear;
        this.surveyBoSet = surveyBoSet;
    }


    /**
     * Getter for property 'surveySetID'.
     *
     * @return Value for property 'surveySetID'.
     */
    public long getSurveySetID() {
        return surveySetID;
    }

    /**
     * Setter for property 'surveySetID'.
     *
     * @param surveySetID Value to set for property 'surveySetID'.
     */
    public void setSurveySetID(long surveySetID) {
        this.surveySetID = surveySetID;
    }

    /**
     * Getter for property 'surveyYear'.
     *
     * @return Value for property 'surveyYear'.
     */
    public LocalDate getSurveyYear() {
        return surveyYear;
    }

    /**
     * Setter for property 'surveyYear'.
     *
     * @param surveyYear Value to set for property 'surveyYear'.
     */
    public void setSurveyYear(LocalDate surveyYear) {
        this.surveyYear = surveyYear;
    }

    /**
     * Getter for property 'surveyBoSet'.
     *
     * @return Value for property 'surveyBoSet'.
     */
    public Set<SurveyBo> getSurveyBoSet() {
        return surveyBoSet;
    }

    /**
     * Setter for property 'surveyBoSet'.
     *
     * @param surveyBoSet Value to set for property 'surveyBoSet'.
     */
    public void setSurveyBoSet(Set<SurveyBo> surveyBoSet) {
        this.surveyBoSet = surveyBoSet;
    }

    @Override
    public int compareTo(SurveySetBo o) {
        throw new NotImplementedException();
    }
}
