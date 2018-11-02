package colruyt.pcrsejb.service.dl.survey;

import colruyt.pcrsejb.entity.survey.SurveySet;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.time.LocalDate;
import java.util.List;

public interface SurveySetService extends GenericCrudService<SurveySet,Integer> {

    List<SurveySet> findSurveySetsByUser(User u);
    SurveySet findSurveySetsByUserAndDate(User u, LocalDate year);



}
