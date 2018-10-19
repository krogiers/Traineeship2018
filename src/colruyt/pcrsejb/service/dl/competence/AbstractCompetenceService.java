package colruyt.pcrsejb.service.dl.competence;

import java.util.Collection;

import colruyt.pcrsejb.service.dl.GenericCrudService;
import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;

public interface AbstractCompetenceService extends GenericCrudService<Competence,Long> {
	
	public Collection<FunctionCompetence> findAllFunctionCompetences();
	public Collection<CraftCompetence> findAllCraftCompetences();

}
