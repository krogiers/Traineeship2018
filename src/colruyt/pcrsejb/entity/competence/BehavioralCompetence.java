package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public class BehavioralCompetence extends CompetenceLevel implements FunctionCompetence {


	public BehavioralCompetence() {
	}

	public BehavioralCompetence(String name, String description) {
		super(name, description);
	}

	public BehavioralCompetence(long competenceID, String name, String description) {
		super(competenceID, name, description);
	}

	public BehavioralCompetence(String name, int minLevel, Map<Integer, String> possibilityMap) {
		super(name, minLevel, possibilityMap);
	}

	public BehavioralCompetence(long competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(competenceID, name, description, minLevel, possibilityMap);
	}
}
