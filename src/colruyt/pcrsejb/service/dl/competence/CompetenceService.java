package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.*;
import colruyt.pcrsejb.service.dl.*;

import java.util.*;

public interface CompetenceService extends GenericCrudService<Competence,Integer> {
	
	public Collection<Competence> findAllFunctionCompetences();
	public Collection<Competence> findAllCraftCompetences();

}
