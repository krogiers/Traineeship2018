package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public class SurveyBoConverter implements GenericConverter<Survey,SurveyBo> {
    @Override
    public Survey convertTo(SurveyBo from) {
       throw new NotImplementedException();
    }
}
