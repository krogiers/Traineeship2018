package colruyt.pcrsejb.service.dl.rating;

import java.util.List;

import colruyt.pcrsejb.entity.competence.DomainCompetence;
import colruyt.pcrsejb.entity.competence.OperatingUnitCompetence;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;
import colruyt.pcrsejb.entity.survey.Rating;
import colruyt.pcrsejb.service.dl.GenericCrudService;

public interface RatingService extends GenericCrudService<Rating,Integer>{
	
	
	public List<DomainCompetence> getAllDomainCompetences();
	public List<OperatingUnitCompetence> getAllOperatingUnitCompetencesFor(OperatingUnit unit);
	

}
