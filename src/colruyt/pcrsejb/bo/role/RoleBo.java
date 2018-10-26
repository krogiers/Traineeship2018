package colruyt.pcrsejb.bo.role;

import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;

public class RoleBo {

	private String name;
    private List<RoleCompetenceBo> roleCompetenceList;

    public RoleBo() {
		super();
	}
	public RoleBo(String name, List<RoleCompetenceBo> roleCompetenceList) {
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

	public List<RoleCompetenceBo> getRoleCompetenceList() {
		return roleCompetenceList;
	}

	public void setRoleCompetenceList(List<RoleCompetenceBo> roleCompetenceList) {
		this.roleCompetenceList = roleCompetenceList;
	}


}
