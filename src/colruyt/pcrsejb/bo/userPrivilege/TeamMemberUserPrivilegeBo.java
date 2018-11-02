package colruyt.pcrsejb.bo.userPrivilege;

import java.time.LocalDate;
import java.util.TreeSet;

import colruyt.pcrsejb.bo.function.FunctionBo;
import colruyt.pcrsejb.bo.survey.SurveySetBo;

public class TeamMemberUserPrivilegeBo extends FunctionUserPrivilegeBo {
	
	private LocalDate startDateInCurrentFunction; 
    private TreeSet<SurveySetBo> surveySetBoTreeSet;
	
	public TeamMemberUserPrivilegeBo(PrivilegeTypeBo privilegeType, boolean active, FunctionBo function, LocalDate startDateInCurrentFunction) {
		super(privilegeType, active, function);
		setSurveySetBoTreeSet(new TreeSet<>());
		setStartDateInCurrentFunction(startDateInCurrentFunction);
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
}
