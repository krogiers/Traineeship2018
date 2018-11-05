package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class Function {

	private Integer id;
    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;
    private int operatingUnitId;


	public Function() {
	}

	public Function(Integer functionID, String title) {
		setId(functionID);
		setTitle(title);
		this.roleSet = new HashSet<>();
		this.functionCompetenceSet = new HashSet<>();
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

	public Function(Integer functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet) {
		this.id = functionID;
		this.title = title;
		this.roleSet = roleSet;
		this.functionCompetenceSet = functionCompetenceSet;
	}

	public Function(Integer functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet, int operatingUnitId) {
		this.id = functionID;
		this.title = title;
		this.roleSet = roleSet;
		this.functionCompetenceSet = functionCompetenceSet;
		this.operatingUnitId = operatingUnitId;
	}

	public Function(Integer id) {
		setId(id);
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer functionID) {
		this.id = functionID;
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

	public int getOperatingUnitId() {
		return operatingUnitId;
	}

	public void setOperatingUnitId(int operatingUnitId) {
		this.operatingUnitId = operatingUnitId;
	}

	@Override
	public String toString() {
		return "Function [title=" + title + ", roleSet=" + roleSet + ", functionCompetenceSet=" + functionCompetenceSet
				+ "]";
	}


}
