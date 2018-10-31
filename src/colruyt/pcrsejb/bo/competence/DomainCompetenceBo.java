package colruyt.pcrsejb.bo.competence;

public class DomainCompetenceBo extends CompetenceBo implements FunctionCompetenceBo {

	public DomainCompetenceBo() {
		super();
	}

	public DomainCompetenceBo(String name)  {
		super(name);
	}

	public DomainCompetenceBo(int competenceID, String name) {
		super(competenceID, name);
	}
}
