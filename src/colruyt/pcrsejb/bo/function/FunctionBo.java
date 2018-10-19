package colruyt.pcrsejb.bo.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class FunctionBo {

    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;


	public FunctionBo() {
	}

	public FunctionBo(String title) {
		this.setTitle(title);
		this.roleSet = new HashSet<>();
		this.functionCompetenceSet = new HashSet<>();
	}

	public FunctionBo(String title, HashSet<Role> roleSet, HashSet<FunctionCompetence> functionCompetenceSet) {
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
		return "FunctionBo [title=" + title + ", roleSet=" + roleSet + ", functionCompetenceSet=" + functionCompetenceSet
				+ "]";
	}
    
    
    
    
}
