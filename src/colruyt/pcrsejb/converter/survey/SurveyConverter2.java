package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyConverter2 implements GenericConverter<SurveyBo,Survey> {


    private RatingConverter conv = new RatingConverter();

    @Override
    public SurveyBo convertTo(Survey from) {

        SurveyBo bo = null;
        switch(determineInstance(from)){
            case "TeamMemberSurvey" : bo = new TeamMemberSurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList())); break;
            case "TeamManagerSurvey" : bo = new TeamManagerSurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList())); break;
            case "ConsensusSurvey" : bo = new ConsensusSurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList())); break;


        }
        return bo;


    }

    private String determineInstance(Survey suy){

        return suy.getClass().getSimpleName();

    }

    protected List<RatingBo> convertRatings(List<Rating> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());
    }


}
