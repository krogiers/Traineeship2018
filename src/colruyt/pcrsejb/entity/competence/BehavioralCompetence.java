package colruyt.pcrsejb.entity.competence;

import java.util.LinkedHashSet;

import colruyt.pcrsejb.entity.competence.exception.CompetenceException;

public class BehavioralCompetence extends Competence implements FunctionCompetence {

	
	private int minLevel;
    private LinkedHashSet<String> possibilityLinkedHashSet;

	
    


	public BehavioralCompetence(String name, String description, int minLevel,
			LinkedHashSet<String> possibilityLinkedHashSet){
		super(name, description);
		this.setMinLevel(minLevel);
		this.setPossibilityLinkedHashSet(possibilityLinkedHashSet);
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


	public LinkedHashSet<String> getPossibilityLinkedHashSet() {
		return possibilityLinkedHashSet;
	}


	public void setPossibilityLinkedHashSet(LinkedHashSet<String> possibilityLinkedHashSet){
//		if (possibilityLinkedHashSet == null){
//			throw new CompetenceException("possibilityLinkedHashSet is null");
//		}
		this.possibilityLinkedHashSet = possibilityLinkedHashSet;
	}
    
    
	
}
