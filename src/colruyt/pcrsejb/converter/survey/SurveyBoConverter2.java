package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.*;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyBoConverter2 implements GenericConverter<Survey,SurveyBo> {

    private RatingBoConverter conv = new RatingBoConverter();

    @Override
    public Survey convertTo(SurveyBo from) {

        Survey bo = null;
        switch(determineInstance(from)){
            case "TeamMemberSurveyBo" : bo = new TeamMemberSurvey(from.getDateCompleted(),convertRatings(from.getRatingBoList())); break;
            case "TeamManagerSurveyBo" : bo = new TeamManagerSurvey(from.getDateCompleted(),convertRatings(from.getRatingBoList())); break;
            case "ConsensusSurveyBo" : bo = new ConsensusSurvey(from.getDateCompleted(),convertRatings(from.getRatingBoList())); break;


        }
        return bo;


    }
    protected List<Rating> convertRatings(List<RatingBo> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());


    }

    private String determineInstance(SurveyBo suy){

        return suy.getClass().getSimpleName();

    }
}
