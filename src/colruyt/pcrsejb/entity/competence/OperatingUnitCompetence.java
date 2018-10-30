package colruyt.pcrsejb.entity.competence;

public class OperatingUnitCompetence extends Competence implements FunctionCompetence {



	public OperatingUnitCompetence() {
		super();
		// TODO Auto-generated constructor stub
	}

	public OperatingUnitCompetence(String name, String description)  {
		super(name, description);
		// TODO Auto-generated constructor stub


	}

	public OperatingUnitCompetence(long competenceID, String name, String description) {
		super(competenceID, name, description);
	}
}
