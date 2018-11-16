package colruyt.pcrsejb.converter.survey;

import colruyt.pcrsejb.bo.survey.RatingBo;
import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveyKindBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.entity.survey.*;

import java.util.List;
import java.util.stream.Collectors;

public class SurveyBoConverter2 implements GenericConverter<Survey,SurveyBo> {

    private RatingBoConverter conv = new RatingBoConverter();

    @Override
    public Survey convertTo(SurveyBo from) {

    
    	switch(from.getKind()) {
    	case TeamMember: return new Survey(from.getDateCompleted(),convertRatings(from.getRatingBoList()),SurveyKind.TeamMember); 
    	case TeamManager: return new Survey(from.getDateCompleted(),convertRatings(from.getRatingBoList()),SurveyKind.TeamManager); 
    	case Consensus: return new Survey(from.getDateCompleted(),convertRatings(from.getRatingBoList()),SurveyKind.Consensus); 
		default: return null;
			
    	
    	
    	}
    	
     


      


    }
    protected List<Rating> convertRatings(List<RatingBo> ratings){

        return ratings.stream().map(x -> conv.convertTo(x)).collect(Collectors.toList());


    }

  
}
