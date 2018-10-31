package colruyt.pcrsejb.bo.competence;

public class DomainCompetenceBo extends CompetenceBo implements FunctionCompetenceBo {

	public DomainCompetenceBo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DomainCompetenceBo(String name, String description)  {
		super(name, description);
		// TODO Auto-generated constructor stub
	}

	public DomainCompetenceBo(int competenceID, String name, String description) {
		super(competenceID, name, description);
	}
}
