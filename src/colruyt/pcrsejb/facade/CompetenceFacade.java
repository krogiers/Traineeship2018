package colruyt.pcrsejb.facade;

import colruyt.pcrsejb.converter.competence.CompetenceBoConverter;
import colruyt.pcrsejb.converter.competence.CompetenceConverter;
import colruyt.pcrsejb.service.bl.CompetenceServiceBL;

public class CompetenceFacade {
	
	private CompetenceServiceBL competenceServiceBL= new CompetenceServiceBL();
	private CompetenceBoConverter competenceBoConverter = new CompetenceBoConverter();
	private CompetenceConverter competenceConverter = new CompetenceConverter();
	
	

}
