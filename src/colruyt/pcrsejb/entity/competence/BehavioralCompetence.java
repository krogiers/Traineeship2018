package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public class BehavioralCompetence extends Competence implements FunctionCompetence {

	
	private int minLevel;
    private Map<Integer,String> possibilityMap;



	public BehavioralCompetence() {
		super();
	}


	public BehavioralCompetence(String name, String description, int minLevel,
			Map<Integer,String> possibilityMap){
		super(name, description);
		this.setMinLevel(minLevel);
		this.setPossibilityMap(possibilityMap);
	}

	public BehavioralCompetence(long competenceID, String name, String description, int minLevel, java.util.Map<Integer, String> possibilityMap) {
		super(competenceID, name, description);
		this.minLevel = minLevel;
		this.possibilityMap = possibilityMap;
	}

	public int getMinLevel() {
		return minLevel;
	}


	public void setMinLevel(int minLevel) {
//		if (minLevel < 0){
//			throw new CompetenceException("minLevel is lower than 0");
//		}
		this.minLevel = minLevel;
	}


	public Map<Integer,String> getPossibilityMap() {
		return possibilityMap;
	}


	public void setPossibilityMap(Map<Integer,String> possibilityMap){
//		if (possibilityMap == null){
//			throw new CompetenceException("possibilityMap is null");
//		}
		this.possibilityMap = possibilityMap;
	}
    
    
	
}
