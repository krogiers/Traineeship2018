package colruyt.pcrsejb.entity.competence;

public class CraftCompetence extends Competence implements RoleCompetence{



	public CraftCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public CraftCompetence(String name, String description)  {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public CraftCompetence(long competenceID, String name, String description) {
		super(competenceID, name, description);
	}
}
