package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.bo.survey.SurveyBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.survey.SurveyBoConverter2;
import colruyt.pcrsejb.converter.survey.SurveyConverter2;
import colruyt.pcrsejb.converter.survey.SurveySetBoConverter;
import colruyt.pcrsejb.converter.survey.SurveySetConverter;
import colruyt.pcrsejb.converter.user.UserBoConverter;
import colruyt.pcrsejb.converter.user.UserConverter;
import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.service.bl.SurveyServiceBL;

import java.util.ArrayList;
import java.util.List;

public class SurveyFacade {
    private SurveyServiceBL surveyServiceBL = new SurveyServiceBL();
    private SurveyConverter2 surveyConverter2 = new SurveyConverter2();
    private SurveySetConverter surveySetConverter = new SurveySetConverter();
    private SurveySetBoConverter surveySetBoConverter = new SurveySetBoConverter();
    private SurveyBoConverter2 surveyBoConverter2 = new SurveyBoConverter2();
    private UserConverter userConverter = new UserConverter();
    private UserBoConverter userBoConverter = new UserBoConverter();

    public List<SurveySetBo> getHistory(UserBo user) {
        List<SurveySetBo> surveySets = new ArrayList<>();
        for (SurveySet set : surveyServiceBL.findSurveySetsByUser(userBoConverter.convertTo(user))) {
        	surveySets.add(surveySetConverter.convertTo(set));
        }
        return surveySets;
    }

	public SurveySetBo getLastSurveySetForUser(UserBo user) {
		return surveySetConverter.convertTo(surveyServiceBL.getLastSurveySetForUser(userBoConverter.convertTo(user)));
	}

	public UserBo getUserOfSurvey(SurveyBo survey) {
		return userConverter.convertTo(surveyServiceBL.findUserBySurvey(surveyBoConverter2.convertTo(survey)));
	}

}
