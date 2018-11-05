package colruyt.pcrsejb.entity.userPrivilege;

import java.time.LocalDate;
import java.util.TreeSet;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.survey.SurveySet;

public class TeamMemberUserPrivilege extends FunctionUserPrivilege {
	
	private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySet> surveySetTreeSet;
	
	public TeamMemberUserPrivilege(PrivilegeType privilegeType, boolean active, Function function, LocalDate startDateInCurrentFunction) {
		super(privilegeType, active, function);
		setSurveySetTreeSet(new TreeSet<>());
		setStartDateInCurrentFunction(startDateInCurrentFunction);
	}
	
	public LocalDate getStartDateInCurrentFunction() {
		return startDateInCurrentFunction;
	}

	public void setStartDateInCurrentFunction(LocalDate startDateInCurrentFunction) {
		this.startDateInCurrentFunction = startDateInCurrentFunction;
	}

	public TreeSet<SurveySet> getSurveySetTreeSet() {
		return surveySetTreeSet;
	}
	
	public void setSurveySetTreeSet(TreeSet<SurveySet> surveySetTreeSet) {
		this.surveySetTreeSet = surveySetTreeSet;
	}

	public void addSurveySet()
	{
		//TO DO: argumenten van de constructor aanvullen
		surveySetTreeSet.add(new SurveySet());
	}
}
