package colruyt.pcrsejb.entity.competence;

import java.util.Map;

public abstract class CompetenceLevel extends DescriptionCompetence{

    private int minLevel;
    private Map<Integer,String> possibilityMap;



    public CompetenceLevel() {
        super();
    }

    public CompetenceLevel(int id, String name){
        super(id, name);
    }

    public CompetenceLevel(String name, String description) {
        super(name, description);
    }

    public CompetenceLevel(int competenceID, String name, String description) {
        super(competenceID, name, description);
    }

    public CompetenceLevel(String name, int minLevel,
                           Map<Integer,String> possibilityMap){
        super(name);
        this.setMinLevel(minLevel);
        this.setPossibilityMap(possibilityMap);
    }



    public CompetenceLevel(int competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
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
