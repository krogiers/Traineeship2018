package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.Collection;

public interface CompetenceService extends GenericCrudService<Competence,Integer> {
	
	Collection<Competence> findAllFunctionCompetences();
	Collection<Competence> findAllCraftCompetences();

}
