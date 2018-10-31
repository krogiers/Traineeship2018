package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public class CraftCompetence extends CompetenceLevel implements RoleCompetence{



	public CraftCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CraftCompetence(String name, String description)  {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public CraftCompetence(int ID, String name){
		super(ID, name);
	}

	public CraftCompetence(int competenceID, String name, String description) {
		super(competenceID, name, description);
	}

	public CraftCompetence(String name, int minLevel, Map<Integer, String> possibilityMap) {
		super(name, minLevel, possibilityMap);
	}

	public CraftCompetence(int competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(competenceID, name, description, minLevel, possibilityMap);
	}

}
