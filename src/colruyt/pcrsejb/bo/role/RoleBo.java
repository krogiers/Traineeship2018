package colruyt.pcrsejb.bo.role;

import colruyt.pcrsejb.bo.competence.RoleCompetenceBo;
import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;
import java.util.Objects;

public class RoleBo {

	private Integer id;
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

	public RoleBo(Integer id, String name, List<RoleCompetenceBo> roleCompetenceBoList) {
		this.id = id;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		RoleBo roleBo = (RoleBo) o;
		return Objects.equals(id, roleBo.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}
