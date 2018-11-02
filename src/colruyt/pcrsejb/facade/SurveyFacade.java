package colruyt.pcrsejb.facade;

import java.util.ArrayList;

import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.converter.survey.SurveyBoConverter2;
import colruyt.pcrsejb.converter.survey.SurveyConverter2;
import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.service.bl.SurveyServiceBL;

public class SurveyFacade {
    private SurveyServiceBL surveyServiceBL = new SurveyServiceBL();
    private SurveyConverter2 surveyConverter2 = new SurveyConverter2();
    private SurveyBoConverter2 surveyBoConverter2 = new SurveyBoConverter2();

    public ArrayList<SurveySet> getHistory() {
        // TODO
        ArrayList<SurveySet> surveys = new ArrayList<>();
        return null;
    }

	public SurveySetBo getLastSurveySetForUser(UserBo subject) {
		// TODO Auto-generated method stub
		return null;
	}
}
