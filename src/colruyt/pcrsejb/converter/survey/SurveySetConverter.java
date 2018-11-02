package colruyt.pcrsejb.converter.survey;

import java.util.HashMap;
import java.util.Map.Entry;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveyKind;
import colruyt.pcrsejb.entity.survey.SurveySet;

public class SurveySetConverter implements GenericConverter<SurveySetBo, SurveySet> {

        @Override
        public SurveySetBo convertTo(SurveySet from) {
            HashMap<SurveyKind, SurveyBo> surveys = new HashMap<>();
            SurveyConverter2 surveyConverter = new SurveyConverter2();
            
            for(Entry<SurveyKind,Survey> s : from.getSurveySet().entrySet()){
            	surveys.put(s.getKey(), surveyConverter.convertTo(s.getValue()));
            }
            return new SurveySetBo(from.getSurveySetID(), from.getSurveyYear(), surveys);
        }

}
