package colruyt.pcrsejb.entity.role;

import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;

public class Role {
	
	private String name;
    private List<RoleCompetence> roleCompetenceList;
    
    public Role() {
		super();
	}
	public Role(String name, List<RoleCompetence> roleCompetenceList) {
		super();
		this.name = name;
		this.roleCompetenceList = roleCompetenceList;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleCompetence> getRoleCompetenceList() {
		return roleCompetenceList;
	}

	public void setRoleCompetenceList(List<RoleCompetence> roleCompetenceList) {
		this.roleCompetenceList = roleCompetenceList;
	}


}
