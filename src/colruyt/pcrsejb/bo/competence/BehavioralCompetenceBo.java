package colruyt.pcrsejb.bo.competence;

import java.util.Map;

public class BehavioralCompetenceBo extends CompetenceLevelBo implements FunctionCompetenceBo {

	public BehavioralCompetenceBo() {
		super();
	}

	public BehavioralCompetenceBo(String name, String description){
		super(name, description);
	}

	public BehavioralCompetenceBo(int competenceID, String name) {
		super(competenceID, name);
	}
	
	public BehavioralCompetenceBo(int competenceID, String name, String description)
	{
		super(competenceID, name, description);
	}
	
	public BehavioralCompetenceBo(String name, int minLevel, Map<Integer, String> possibilityMap) {
		super(name, minLevel, possibilityMap);
	}

	public BehavioralCompetenceBo(int competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(competenceID, name, description, minLevel, possibilityMap);
	}
		
}
