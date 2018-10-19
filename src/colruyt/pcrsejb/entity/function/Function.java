package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.Set;

public class Function {

    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;
    
	public Function(String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet) {
		super();
		this.title = title;
		this.roleSet = roleSet;
		this.functionCompetenceSet = functionCompetenceSet;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Set<Role> getRoleSet() {
		return roleSet;
	}

	public void setRoleSet(Set<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public Set<FunctionCompetence> getFunctionCompetenceSet() {
		return functionCompetenceSet;
	}

	public void setFunctionCompetenceSet(Set<FunctionCompetence> functionCompetenceSet) {
		this.functionCompetenceSet = functionCompetenceSet;
	}

	@Override
	public String toString() {
		return "Function [title=" + title + ", roleSet=" + roleSet + ", functionCompetenceSet=" + functionCompetenceSet
				+ "]";
	}
    
    
    
    
}
