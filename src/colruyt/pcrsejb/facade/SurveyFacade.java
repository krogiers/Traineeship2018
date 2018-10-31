package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.converter.survey.SurveyBoConverter2;
import colruyt.pcrsejb.converter.survey.SurveyConverter2;
import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.service.bl.SurveyServiceBL;

import java.util.ArrayList;

public class SurveyFacade {
    private SurveyServiceBL surveyServiceBL = new SurveyServiceBL();
    private SurveyConverter2 surveyConverter2 = new SurveyConverter2();
    private SurveyBoConverter2 surveyBoConverter2 = new SurveyBoConverter2();

    public ArrayList<SurveySet> getHistory() {
        // TODO
        return null;

    }

}
