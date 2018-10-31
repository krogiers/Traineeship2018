package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveySet;

import java.util.HashSet;
import java.util.Set;

public class SurveySetConverter implements GenericConverter<SurveySetBo, SurveySet> {



        @Override
        public SurveySetBo convertTo(SurveySet from) {
            Set<SurveyBo> surveys = new HashSet<>();
            SurveyConverter2 surveyConverter = new SurveyConverter2();
            for(Survey s : from.getSurveySet()){
                surveys.add(surveyConverter.convertTo(s));
            }
            return new SurveySetBo(from.getSurveySetID(), from.getSurveyYear(), surveys);
        }

}
