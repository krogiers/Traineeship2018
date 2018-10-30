package colruyt.pcrsejb.bo.competence;

import java.util.Map;

public class BehavioralCompetenceBo extends CompetenceBo implements FunctionCompetenceBo {

	
	private int minLevel;
    private Map<Integer,String> possibilityMap;



	public BehavioralCompetenceBo() {
		super();
	}


	public BehavioralCompetenceBo(String name, String description, int minLevel,
								  Map<Integer,String> possibilityMap){
		super(name, description);
		this.setMinLevel(minLevel);
		this.setPossibilityMap(possibilityMap);
	}

	public BehavioralCompetenceBo(long competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
		super(competenceID, name, description);
		this.minLevel = minLevel;
		this.possibilityMap = possibilityMap;
	}

	public int getMinLevel() {
		return minLevel;
	}


	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}


	public Map<Integer,String> getPossibilityMap() {
		return possibilityMap;
	}


	public void setPossibilityMap(Map<Integer,String> possibilityMap){
		this.possibilityMap = possibilityMap;
	}
    
    
	
}
