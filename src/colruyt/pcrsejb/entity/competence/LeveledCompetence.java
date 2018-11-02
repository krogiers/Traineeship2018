package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public abstract class LeveledCompetence extends Competence{

	private String description;
    private int minLevel;
    private Map<Integer,String> possibilityMap;

    public LeveledCompetence() {
        super();
    }

    public LeveledCompetence(int id, String name, String description)
    {
    	super(id, name);
    	this.setDescription(description);
    	//TODO possibilities uit een enum?
    }
    
    public LeveledCompetence(String name, String description)
    {
    	super(name);
    	this.setDescription(description);
    	//TODO possibilities uit een enum?
    }
    
    public LeveledCompetence(int id, String name, String description, Map<Integer, String> possibilityMap)
    {
    	super(id, name);
    	this.setDescription(description);
    	this.setPossibilityMap(possibilityMap);
    }
    
    public LeveledCompetence(String name, String description, Map<Integer, String> possibilityMap)
    {
    	super(name);
    	this.setDescription(description);
    	this.setPossibilityMap(possibilityMap);	
    }

    public LeveledCompetence(int id, String name, String description, int minLevel, Map<Integer, String> possibilityMap) 
    {
    	super(id, name);
    	this.setDescription(description);
    	this.setMinLevel(minLevel);
    	this.setPossibilityMap(possibilityMap);
    }
   
    public LeveledCompetence(String name, String description, int minLevel, Map<Integer, String> possibilityMap) 
    {
        super(name);
        this.setDescription(description);
        this.setMinLevel(minLevel);
        this.setPossibilityMap(possibilityMap);
    }

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getMinLevel() {
		return minLevel;
	}

	public void setMinLevel(int minLevel) {
		this.minLevel = minLevel;
	}

	public Map<Integer, String> getPossibilityMap() {
		return possibilityMap;
	}

	public void setPossibilityMap(Map<Integer, String> possibilityMap) {
		this.possibilityMap = possibilityMap;
	}
      
    
}
