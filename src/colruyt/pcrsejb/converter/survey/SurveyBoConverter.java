package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;

import java.util.List;
import java.util.stream.Collectors;


public abstract class SurveyBoConverter<T extends SurveyBo> implements GenericConverter<Survey,T> {



    private RatingBoConverter conv = new RatingBoConverter();


    protected List<Rating> convertRatings(List<RatingBo> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());


    }


}
