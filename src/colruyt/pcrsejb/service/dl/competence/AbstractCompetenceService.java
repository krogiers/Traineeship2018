package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.*;
import colruyt.pcrsejb.service.dl.*;

import java.util.*;

public interface AbstractCompetenceService extends GenericCrudService<Competence,Long> {
	
	public Collection<FunctionCompetence> findAllFunctionCompetences();
	public Collection<CraftCompetence> findAllCraftCompetences();

}
