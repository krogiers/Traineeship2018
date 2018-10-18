package colruyt.pcrsejb.entity.user.privileges;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.time.LocalDate;
import java.util.TreeSet;

public class TeamMemberPrivilege extends FunctionHoldingPrivilege {

    private LocalDate yearsInCurrentFunction;
    private TreeSet<SurveySet> surveySetTreeSet;


}
