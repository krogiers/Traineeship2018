package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemorySurveySetService implements SurveySetService {

    private static List<SurveySet> surveylist = new ArrayList<>();

    @Override
    public SurveySet save(SurveySet element) {

        element.setSurveySetID(surveylist.size() + 1);
        surveylist.add(element);

        return element;
    }

    @Override
    public SurveySet getElement(SurveySet surveySet) {
        return surveylist.get(surveySet.getSurveySetID());
    }

    @Override
    public Collection<SurveySet> getAllElements() {
        return this.surveylist;
    }

    @Override
    public void deleteElement(SurveySet element) {
        this.surveylist.remove(element);
    }
}
