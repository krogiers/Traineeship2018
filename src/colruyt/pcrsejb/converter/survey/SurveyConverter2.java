package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.*;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveyKind;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyConverter2 implements GenericConverter<SurveyBo,Survey> {


    private RatingConverter conv = new RatingConverter();

    @Override
    public SurveyBo convertTo(Survey from) {

    	switch(from.getSurveyKind()) {
    	case TeamMember: return new SurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList()),SurveyKindBo.TeamMember); 
    	case TeamManager: return new SurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList()),SurveyKindBo.TeamManager); 
    	case Consensus: return new SurveyBo(from.getDateCompleted(),convertRatings(from.getRatingList()),SurveyKindBo.Consensus); 
		default: return null;

    	}
    }



    protected List<RatingBo> convertRatings(List<Rating> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());
    }


}
