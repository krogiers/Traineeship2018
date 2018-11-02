package colruyt.pcrsejb.bo.competence;

import java.util.Map;

public class CraftCompetenceBo extends LeveledCompetenceBo implements RoleCompetenceBo {

	public CraftCompetenceBo() {
		super();
	}

	public CraftCompetenceBo(String name, String description){
		super(name, description);
	}

	public CraftCompetenceBo(int id, String name, String description) {
		super(id, name, description);
	}
	
	public CraftCompetenceBo(String name, String description, Map<Integer, String> possibilityMap){
		super(name, description, possibilityMap);
	}
	
	public CraftCompetenceBo(int id, String name, String description, Map<Integer, String> possibilityMap){
		super(id, name, description, possibilityMap);
	}

}
