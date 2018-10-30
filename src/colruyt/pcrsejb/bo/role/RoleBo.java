package colruyt.pcrsejb.bo.role;

import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;

public class RoleBo {

	private String name;
    private List<RoleCompetenceBo> roleCompetenceBoList;

    public RoleBo() {
		super();
	}

	public RoleBo(String name, List<RoleCompetenceBo> roleCompetenceBoList) {
		super();
		this.name = name;
		this.roleCompetenceBoList = roleCompetenceBoList;
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<RoleCompetenceBo> getRoleCompetenceBoList() {
		return roleCompetenceBoList;
	}

	public void setRoleCompetenceBoList(List<RoleCompetenceBo> roleCompetenceBoList) {
		this.roleCompetenceBoList = roleCompetenceBoList;
	}


}
