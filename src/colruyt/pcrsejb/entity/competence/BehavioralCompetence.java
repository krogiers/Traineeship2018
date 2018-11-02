package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public class BehavioralCompetence extends LeveledCompetence implements FunctionCompetence {


	public BehavioralCompetence() {
		super();
	}

	public BehavioralCompetence(String name, String description){
		super(name, description);
	}

	public BehavioralCompetence(int id, String name, String description) {
		super(id, name, description);
	}
	
	public BehavioralCompetence(String name, String description, Map<Integer, String> possibilityMap){
		super(name, description, possibilityMap);
	}
	
	public BehavioralCompetence(int id, String name, String description, Map<Integer, String> possibilityMap){
		super(id, name, description, possibilityMap);
	}
	
	public BehavioralCompetence(String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(name, description, minLevel, possibilityMap);
	}
	
	public BehavioralCompetence(int id, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(id, name, description, minLevel, possibilityMap);
	}
}
