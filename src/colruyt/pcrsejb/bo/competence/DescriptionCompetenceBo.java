package colruyt.pcrsejb.bo.competence;

public abstract class DescriptionCompetenceBo extends CompetenceBo {

    private String description;

    public DescriptionCompetenceBo() {
    }

    public DescriptionCompetenceBo(String description) {
        this.description = description;
    }

    public DescriptionCompetenceBo(String name, String description) {
        super(name);
        this.description = description;
    }

    public DescriptionCompetenceBo(int competenceID, String name) {
        super(competenceID, name);
    }

    public DescriptionCompetenceBo(int competenceID, String name, String description) {
        super(competenceID, name);
        this.description = description;
    }

    /**
     * Getter for property 'description'.
     *
     * @return Value for property 'description'.
     */
    public String getDescription() {
        return description;
    }

    /**
     * Setter for property 'description'.
     *
     * @param description Value to set for property 'description'.
     */
    public void setDescription(String description) {
        this.description = description;
    }
}
