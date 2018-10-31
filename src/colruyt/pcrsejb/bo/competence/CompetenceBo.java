package colruyt.pcrsejb.bo.competence;

public abstract class CompetenceBo {

	private int competenceID;
    private String name;
    
	public CompetenceBo() {
		super();
	}

	public CompetenceBo(String name)  {
		super();
		this.setName(name);
	}

	public CompetenceBo(int competenceID, String name) {
		this.setCompetenceID(competenceID);
		this.setName(name);
	}

	public int getCompetenceID() {
		return competenceID;
	}

	public void setCompetenceID(int competenceID) {
		this.competenceID = competenceID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name)  {
		this.name = name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + competenceID;
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
		if (competenceID != other.competenceID)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}


}
