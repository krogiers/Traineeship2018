package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Survey;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

public interface SurveyConverter<T extends Survey> extends GenericConverter<SurveyBo,T> {



}
