package colruyt.pcrsejb.entity.competence;

import java.util.LinkedHashSet;
import java.util.Map;

import colruyt.pcrsejb.entity.competence.exception.CompetenceException;

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
