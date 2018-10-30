package colruyt.pcrsejb.entity.competence;

public class DomainCompetence extends Competence implements FunctionCompetence {

	public DomainCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainCompetence(String name, String description)  {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public DomainCompetence(long competenceID, String name, String description) {
		super(competenceID, name, description);
	}
}
