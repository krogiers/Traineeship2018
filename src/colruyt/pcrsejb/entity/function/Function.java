package colruyt.pcrsejb.entity.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.role.Role;

import java.util.HashSet;
import java.util.Set;

public class Function {

<<<<<<< HEAD
	private Integer id;
=======
	private Integer functionID;
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
    private String title;
    private Set<Role> roleSet;
    private Set<FunctionCompetence> functionCompetenceSet;
    private int operatingUnitId;


	public Function() {
	}

<<<<<<< HEAD
	public Function(int functionID, String title) {
		setId(functionID);
=======
	public Function(Integer functionID, String title) {
		setFunctionID(functionID);
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
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

<<<<<<< HEAD
	public Function(int functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet) {
		this.id = functionID;
=======
	public Function(Integer functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet) {
		this.functionID = functionID;
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
		this.title = title;
		this.roleSet = roleSet;
		this.functionCompetenceSet = functionCompetenceSet;
	}

<<<<<<< HEAD
	public Function(int functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet, int operatingUnitId) {
		this.id = functionID;
=======
	public Function(Integer functionID, String title, Set<Role> roleSet, Set<FunctionCompetence> functionCompetenceSet, int operatingUnitId) {
		this.functionID = functionID;
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
		this.title = title;
		this.roleSet = roleSet;
		this.functionCompetenceSet = functionCompetenceSet;
		this.operatingUnitId = operatingUnitId;
	}

<<<<<<< HEAD
	public Function(Integer id) {
		setId(id);
=======
	public Integer getFunctionID() {
		return functionID;
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
	}

<<<<<<< HEAD
	public Integer getId() {
		return id;
	}

	public void setId(Integer functionID) {
		this.id = functionID;
=======
	public void setFunctionID(Integer functionID) {
		this.functionID = functionID;
>>>>>>> branch 'master' of https://github.com/krogiers/Traineeship2018.git
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
