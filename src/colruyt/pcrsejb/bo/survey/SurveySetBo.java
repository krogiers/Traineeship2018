package colruyt.pcrsejb.bo.survey;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.Set;

public class SurveySetBo implements Comparable<SurveySetBo>{

    private LocalDate surveyYear;
    private Set<SurveyBo> surveyBoSet;

    @Override
    public int compareTo(SurveySetBo o) {
        throw new NotImplementedException();
    }
}
