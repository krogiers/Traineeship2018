package colruyt.pcrsejb.entity.role;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.RoleCompetence;

import java.util.List;

public class Role {
	
	private String name;
    private List<RoleCompetence> craftCompetenceList;
    
    public Role() {
		super();
	}
	public Role(String name, List<RoleCompetence> craftCompetenceList) {
		super();
		this.name = name;
		this.craftCompetenceList = craftCompetenceList;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<RoleCompetence> getCraftCompetenceList() {
		return craftCompetenceList;
	}
	public void setCraftCompetenceList(List<RoleCompetence> craftCompetenceList) {
		this.craftCompetenceList = craftCompetenceList;
	}


}
