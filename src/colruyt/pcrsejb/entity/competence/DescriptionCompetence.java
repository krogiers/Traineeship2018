package colruyt.pcrsejb.entity.competence;

public abstract class DescriptionCompetence extends Competence {

    private String description;

    public DescriptionCompetence() {
    }

    public DescriptionCompetence(String description) {
        this.description = description;
    }

    public DescriptionCompetence(String name, String description) {
        super(name);
        this.description = description;
    }

    public DescriptionCompetence(int competenceID, String name) {
        super(competenceID, name);
    }

    public DescriptionCompetence(int competenceID, String name, String description) {
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
