package colruyt.pcrsejb.bo.privileges;

import colruyt.pcrsejb.bo.survey.SurveySetBo;

import java.time.LocalDate;
import java.util.TreeSet;

public class TeamMemberPrivilegeBo extends FunctionHoldingPrivilegeBo {

    private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySetBo> surveySetBoTreeSet;
    
    public TeamMemberPrivilegeBo() {
		super();
		this.setStartDateInCurrentFunction(null);
		this.setSurveySetBoTreeSet(new TreeSet<>());
		setId(1);
	}
	
	public TeamMemberPrivilegeBo(LocalDate startDateInCurrentFunction) {
		super();
		this.setStartDateInCurrentFunction(startDateInCurrentFunction);
		this.setSurveySetBoTreeSet(new TreeSet<>());
		setId(1);
	}

	
	public LocalDate getStartDateInCurrentFunction() {
		return startDateInCurrentFunction;
	}

	public void setStartDateInCurrentFunction(LocalDate startDateInCurrentFunction) {
		this.startDateInCurrentFunction = startDateInCurrentFunction;
	}

	public TreeSet<SurveySetBo> getSurveySetBoTreeSet() {
		return surveySetBoTreeSet;
	}
	
	public void setSurveySetBoTreeSet(TreeSet<SurveySetBo> surveySetBoTreeSet) {
		this.surveySetBoTreeSet = surveySetBoTreeSet;
	}

	public void addSurveySet()
	{
		//TO DO: argumenten van de constructor aanvullen
		surveySetBoTreeSet.add(new SurveySetBo());
	}
	
	
	@Override
	public String toString() {
		return "TeamMemberPrivilegeBo [function=" + this.getFunctionBo() + ", startDateInCurrentFunction=" + startDateInCurrentFunction + "]";
	}
}
