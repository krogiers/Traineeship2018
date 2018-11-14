package colruyt.pcrsejb.entity.role;

import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;
import java.util.Objects;

public class Role {

	private Integer id;
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

	public Role(Integer id, String name, List<RoleCompetence> roleCompetenceList) {
		this.id = id;
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
		Role role = (Role) o;
		return Objects.equals(id, role.id);
	}

	@Override
	public int hashCode() {

		return Objects.hash(id);
	}
}
