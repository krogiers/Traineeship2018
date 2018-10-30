package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.List;
import java.util.stream.Collectors;

public abstract class SurveyConverter<T extends Survey> implements GenericConverter<SurveyBo,T> {


    private RatingConverter conv = new RatingConverter();

    protected List<RatingBo> convertRatings(List<Rating> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());
    }




}
