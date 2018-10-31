package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveySet;

import java.util.HashSet;
import java.util.Set;

public class SurveySetBoConverter implements GenericConverter<SurveySet, SurveySetBo> {


    @Override
    public SurveySet convertTo(SurveySetBo from) {
        Set<Survey> surveys = new HashSet<>();
        SurveyBoConverter2 surveyConverter = new SurveyBoConverter2();
        for(SurveyBo s : from.getSurveyBoSet()){
            surveys.add(surveyConverter.convertTo(s));
        }
        return new SurveySet(from.getSurveySetID(), from.getSurveyYear(), surveys);
    }

}
