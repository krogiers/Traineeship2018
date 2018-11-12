package colruyt.pcrsejb.service.bl;

import colruyt.pcrsejb.entity.survey.Survey;
import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.survey.MemorySurveySetService;
import colruyt.pcrsejb.service.dl.survey.SurveySetService;

import java.time.LocalDate;
import java.util.List;

public class SurveyServiceBL {

    private SurveySetService surveyService = new MemorySurveySetService();


    public List<SurveySet> findSurveySetsByUser(User u){

            return surveyService.findSurveySetsByUser(u);

    }

    public SurveySet findSurveySetsByUserAndYear(User u , LocalDate year){
        return surveyService.findSurveySetsByUserAndDate(u,year);
    }

    public SurveySet save(SurveySet toSave){
        //TOdo:Validate ?? wat is een geldige Survey

          return surveyService.save(toSave);
    }


    public void notifyTeamManager(){

        //Todo: Event ???
    }

	public User findUserBySurvey(Survey survey) {
		return surveyService.findUserBySurvey(survey);
	}

	public SurveySet getLastSurveySetForUser(User user) {
		return surveyService.findLastSurveySetForUser(user);
	}






}
