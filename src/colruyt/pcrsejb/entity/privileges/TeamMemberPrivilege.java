package colruyt.pcrsejb.entity.privileges;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class TeamMemberPrivilege extends FunctionHoldingPrivilege {

    private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySet> surveySetTreeSet;



    public TeamMemberPrivilege() {
		super();
		this.setStartDateInCurrentFunction(null);;
		this.setSurveySetTreeSet(new TreeSet<SurveySet>());
		this.setId(1);
	}
	
	public TeamMemberPrivilege(LocalDate startDateInCurrentFunction) {
		super();
		this.setStartDateInCurrentFunction(startDateInCurrentFunction);;
		this.setSurveySetTreeSet(new TreeSet<SurveySet>());;
		this.setId(1);
	}

	
	public LocalDate getStartDateInCurrentFunction() {
		return startDateInCurrentFunction;
	}

	public void setStartDateInCurrentFunction(LocalDate startDateInCurrentFunction) {
		this.startDateInCurrentFunction = startDateInCurrentFunction;
	}

	public Set<SurveySet> getSurveySetTreeSet() {
		return surveySetTreeSet;
	}
	
	public void setSurveySetTreeSet(TreeSet<SurveySet> surveySetTreeSet) {
		this.surveySetTreeSet = surveySetTreeSet;
	}

	public void addSurveySet()
	{
		//TODO: argumenten van de constructor aanvullen
		surveySetTreeSet.add(new SurveySet());
	}
	
	
	@Override
	public String toString() {
		return "TeamMemberPrivilege [function=" + this.getFunction() + ", startDateInCurrentFunction=" + startDateInCurrentFunction + "]";
	}
}
