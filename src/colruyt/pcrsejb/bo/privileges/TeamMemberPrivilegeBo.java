package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.entity.survey.SurveySet;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class TeamMemberPrivilegeBo extends FunctionHoldingPrivilegeBo {

    private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySet> surveySetTreeSet;
    
    public TeamMemberPrivilegeBo() {
		super();
		this.setStartDateInCurrentFunction(null);;
		this.setSurveySetTreeSet(new TreeSet<SurveySet>());
	}
	
	public TeamMemberPrivilegeBo(LocalDate startDateInCurrentFunction) {
		super();
		this.setStartDateInCurrentFunction(startDateInCurrentFunction);;
		this.setSurveySetTreeSet(new TreeSet<SurveySet>());;
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
		//TO DO: argumenten van de constructor aanvullen
		surveySetTreeSet.add(new SurveySet());
	}
	
	
	@Override
	public String toString() {
		return "TeamMemberPrivilegeBo [function=" + this.getFunction() + ", startDateInCurrentFunction=" + startDateInCurrentFunction + "]";
	}
}
