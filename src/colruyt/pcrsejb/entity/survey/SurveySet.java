package colruyt.pcrsejb.entity.survey;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.time.LocalDate;
import java.util.Set;

public class SurveySet implements Comparable<SurveySet>{

    private LocalDate surveyYear;
    private Set<Survey> surveySet;

    @Override
    public int compareTo(SurveySet o) {
        throw new NotImplementedException();
    }
}
