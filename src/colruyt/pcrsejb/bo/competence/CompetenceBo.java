package colruyt.pcrsejb.bo.competence;

public abstract class CompetenceBo {

	private long competenceID;

    private String name;
    private String description;
    
	public CompetenceBo() {
		super();
	}

	public CompetenceBo(String name, String description)  {
		super();
		this.setName(name);
		this.setDescription(description);
	}

	public CompetenceBo(long competenceID, String name, String description) {
		this.competenceID = competenceID;
		this.name = name;
		this.description = description;
	}

	public Long getCompetenceID() {
		return competenceID;
	}

	public void setCompetenceID(long competenceID) {
		this.competenceID = competenceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)  {
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
		result = prime * result + ((description == null) ? 0 : description.hashCode());
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
		CompetenceBo other = (CompetenceBo) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	


}
