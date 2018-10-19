package colruyt.pcrsejb.entity.user.privileges;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.time.LocalDate;
import java.util.TreeSet;

public class TeamMemberPrivilege extends FunctionHoldingPrivilege {

    private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySet> surveySetTreeSet;
    
    public TeamMemberPrivilege() {
		super();
		this.startDateInCurrentFunction = null;
		this.surveySetTreeSet = new TreeSet<SurveySet>();
	}
	
	public TeamMemberPrivilege(LocalDate startDateInCurrentFunction) {
		super();
		this.startDateInCurrentFunction = startDateInCurrentFunction;
		this.surveySetTreeSet = new TreeSet<SurveySet>();
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
	
	
	@Override
	public String toString() {
		return "TeamMemberPrivilege [function=" + this.getFunction() + ", startDateInCurrentFunction=" + startDateInCurrentFunction + "]";
	}
}
