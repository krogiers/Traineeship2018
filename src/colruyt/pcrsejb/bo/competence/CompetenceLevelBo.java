package colruyt.pcrsejb.bo.competence;


import java.util.Map;

public abstract class CompetenceLevelBo extends DescriptionCompetenceBo {

    private int minLevel;
    private Map<Integer, String> possibilityMap;


    public CompetenceLevelBo() {
        super();
    }

    public CompetenceLevelBo(int id, String name) {
        super(id, name);
    }

    public CompetenceLevelBo(String name, String description) {
        super(name, description);
    }

    public CompetenceLevelBo(int competenceID, String name, String description) {
        super(competenceID, name, description);
    }

    public CompetenceLevelBo(String name, int minLevel,
                             Map<Integer, String> possibilityMap) {
        super(name);
        this.setMinLevel(minLevel);
        this.setPossibilityMap(possibilityMap);
    }


    public CompetenceLevelBo(int competenceID, String name, String description, int minLevel, Map<Integer, String> possibilityMap) {
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


    public Map<Integer, String> getPossibilityMap() {
        return possibilityMap;
    }


    public void setPossibilityMap(Map<Integer, String> possibilityMap) {

        this.possibilityMap = possibilityMap;
    }
}