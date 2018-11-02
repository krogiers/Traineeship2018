package colruyt.pcrsejb.bo.competence;

import java.util.Map;

public class BehavioralCompetenceBo extends LeveledCompetenceBo implements FunctionCompetenceBo {

	public BehavioralCompetenceBo() {
		super();
	}

	public BehavioralCompetenceBo(String name, String description){
		super(name, description);
	}

	public BehavioralCompetenceBo(int id, String name, String description) {
		super(id, name, description);
	}
	
	public BehavioralCompetenceBo(String name, String description, Map<Integer, String> possibilityMap){
		super(name, description, possibilityMap);
	}
	
	public BehavioralCompetenceBo(int id, String name, String description, Map<Integer, String> possibilityMap){
		super(id, name, description, possibilityMap);
	}
	
	public BehavioralCompetenceBo(String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(name, description, minLevel, possibilityMap);
	}
	
	public BehavioralCompetenceBo(int id, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(id, name, description, minLevel, possibilityMap);
	}
		
}
