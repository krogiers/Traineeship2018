package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemorySurveyService implements SurveySetService {

    private List<SurveySet> surveylist = new ArrayList<>();

    @Override
    public void addElement(SurveySet element) {
        surveylist.add(element);
    }

    @Override
    public SurveySet getElement(Long index) {
        return surveylist.get(index.intValue());
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
