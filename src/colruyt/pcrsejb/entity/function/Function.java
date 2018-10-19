package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class Function {

    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;


	public Function() {
	}

	public Function(String title) {
		this.setTitle(title);
		this.roleSet = new HashSet<>();
		this.functionCompetenceSet = new HashSet<>();
	}

	public Function(String title, HashSet<Role> roleSet, HashSet<FunctionCompetence> functionCompetenceSet) {
		super();
		this.setTitle(title);
		this.setRoleSet(roleSet);
		this.setFunctionCompetenceSet(functionCompetenceSet);
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

	public void setRoleSet(HashSet<Role> roleSet) {
		this.roleSet = roleSet;
	}

	public Set<FunctionCompetence> getFunctionCompetenceSet() {
		return functionCompetenceSet;
	}

	public void setFunctionCompetenceSet(HashSet<FunctionCompetence> functionCompetenceSet) {
		this.functionCompetenceSet = functionCompetenceSet;
	}

	@Override
	public String toString() {
		return "Function [title=" + title + ", roleSet=" + roleSet + ", functionCompetenceSet=" + functionCompetenceSet
				+ "]";
	}
    
    
    
    
}
