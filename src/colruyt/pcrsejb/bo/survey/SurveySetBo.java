package colruyt.pcrsejb.bo.survey;

import java.time.LocalDate;
import java.util.HashMap;

import colruyt.pcrsejb.entity.survey.SurveyKind;

public class SurveySetBo implements Comparable<SurveySetBo>{


    private long surveySetID;
    private LocalDate surveyYear;
    private HashMap<SurveyKind, SurveyBo> surveyBoSet;


    public SurveySetBo() {
    }

    public SurveySetBo(LocalDate surveyYear, HashMap<SurveyKind, SurveyBo> surveyBoSet) {
        this.surveyYear = surveyYear;
        this.surveyBoSet = surveyBoSet;
    }

    public SurveySetBo(long surveySetID, LocalDate surveyYear, HashMap<SurveyKind, SurveyBo> surveyBoSet) {
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
    public HashMap<SurveyKind, SurveyBo> getSurveyBoSet() {
        return surveyBoSet;
    }

    /**
     * Setter for property 'surveyBoSet'.
     *
     * @param surveyBoSet Value to set for property 'surveyBoSet'.
     */
    public void setSurveyBoSet(HashMap<SurveyKind, SurveyBo> surveyBoSet) {
        this.surveyBoSet = surveyBoSet;
    }

    @Override
    public int compareTo(SurveySetBo o) {
        return this.surveyYear.compareTo(o.getSurveyYear());
    }
}
