package colruyt.pcrsejb.converter.survey;

import java.util.HashMap;
import java.util.Map.Entry;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveyKind;
import colruyt.pcrsejb.entity.survey.SurveySet;

public class SurveySetBoConverter implements GenericConverter<SurveySet, SurveySetBo> {


    @Override
    public SurveySet convertTo(SurveySetBo from) {
        HashMap<SurveyKind, Survey> surveys = new HashMap<>();
        SurveyBoConverter2 surveyConverter = new SurveyBoConverter2();
        
        for(Entry<SurveyKind,SurveyBo> s : from.getSurveyBoSet().entrySet()){
        	surveys.put(s.getKey(), surveyConverter.convertTo(s.getValue()));
        }
        return new SurveySet(from.getSurveySetID(), from.getSurveyYear(), surveys);
    }

}
