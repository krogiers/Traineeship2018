package colruyt.pcrsejb.entity.competence;

public abstract class Competence {

	private Integer competenceID;
    private String name;
    private String description;

	public Competence(Integer competenceID, String name, String description) {
		this.competenceID = competenceID;
		this.name = name;
		this.description = description;
	}

	public Competence() {
		super();
	}
	public Competence(String name)  {
		super();
		this.setName(name);
	}

	public Competence(Integer competenceID, String name) {
		this.competenceID = competenceID;
		this.name = name;

	}

	/**
	 * Getter for property 'competenceID'.
	 *
	 * @return Value for property 'competenceID'.
	 */
	public Integer getCompetenceID() {
		return competenceID;
	}

	/**
	 * Setter for property 'competenceID'.
	 *
	 * @param competenceID Value to set for property 'competenceID'.
	 */
	public void setCompetenceID(Integer competenceID) {
		this.competenceID = competenceID;
	}

	public String getName() {
		return name;
	}
	public void setName(String name)  {
//		if(name == null){
//			throw new CompetenceException("name is null");
//		}
//		if(name.isEmpty()){
//			throw new CompetenceException("name is empty");
//		}
		
		this.name = name;
	}


	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;

		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Competence other = (Competence) obj;

		if (name == null) {
			if (other.name != null )
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	


}
