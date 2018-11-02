package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public class CraftCompetence extends LeveledCompetence implements RoleCompetence{

	public CraftCompetence() {
		super();
	}

	public CraftCompetence(String name, String description){
		super(name, description);
	}

	public CraftCompetence(int id, String name, String description) {
		super(id, name, description);
	}
	
	public CraftCompetence(String name, String description, Map<Integer, String> possibilityMap){
		super(name, description, possibilityMap);
	}
	
	public CraftCompetence(int id, String name, String description, Map<Integer, String> possibilityMap){
		super(id, name, description, possibilityMap);
	}
}
