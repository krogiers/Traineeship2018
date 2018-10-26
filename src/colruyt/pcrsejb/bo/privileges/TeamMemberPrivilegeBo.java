package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.bo.survey.SurveySetBo;
import colruyt.pcrsejb.entity.survey.SurveySet;

import java.time.LocalDate;
import java.util.Set;
import java.util.TreeSet;

public class TeamMemberPrivilegeBo extends FunctionHoldingPrivilegeBo {

    private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySetBo> surveySetTreeSet;
    
    public TeamMemberPrivilegeBo() {
		super();
		this.setStartDateInCurrentFunction(null);;
		this.setSurveySetTreeSet(new TreeSet<SurveySetBo>());
	}
	
	public TeamMemberPrivilegeBo(LocalDate startDateInCurrentFunction) {
		super();
		this.setStartDateInCurrentFunction(startDateInCurrentFunction);;
		this.setSurveySetTreeSet(new TreeSet<SurveySetBo>());;
	}

	
	public LocalDate getStartDateInCurrentFunction() {
		return startDateInCurrentFunction;
	}

	public void setStartDateInCurrentFunction(LocalDate startDateInCurrentFunction) {
		this.startDateInCurrentFunction = startDateInCurrentFunction;
	}

	public Set<SurveySetBo> getSurveySetTreeSet() {
		return surveySetTreeSet;
	}
	
	public void setSurveySetTreeSet(TreeSet<SurveySetBo> surveySetTreeSet) {
		this.surveySetTreeSet = surveySetTreeSet;
	}

	public void addSurveySet()
	{
		//TO DO: argumenten van de constructor aanvullen
		surveySetTreeSet.add(new SurveySetBo());
	}
	
	
	@Override
	public String toString() {
		return "TeamMemberPrivilegeBo [function=" + this.getFunction() + ", startDateInCurrentFunction=" + startDateInCurrentFunction + "]";
	}
}
