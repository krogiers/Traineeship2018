package colruyt.pcrsejb.entity.competence;

public class DomainCompetence extends Competence implements FunctionCompetence {

	public DomainCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainCompetence(String name)  {
		super(name);
		// TODO Auto-generated constructor stub
	}

	public DomainCompetence(int competenceID, String name, String description) {
		super(competenceID, name);
	}
}
