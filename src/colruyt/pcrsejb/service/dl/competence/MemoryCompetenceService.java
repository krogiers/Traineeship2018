package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;
import colruyt.pcrsejb.entity.competence.CraftCompetence;
import colruyt.pcrsejb.entity.competence.FunctionCompetence;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class MemoryCompetenceService implements CompetenceService {

	private static List<Competence> db = new ArrayList<>();
	
	@Override
	public Competence save(Competence element) {
		element.setCompetenceID(db.size() + 1);
		db.add(element);
		return element;
		
	}

	@Override
	public Competence getElement(Integer index) {
		return db.get((index));
	}

	@Override
	public List<Competence> getAllElements() {
		
		return db;
	}

	@Override
	public void deleteElement(Competence element) {
		db.remove(element);
		
	}

	@Override
	public Collection<FunctionCompetence> findAllFunctionCompetences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<CraftCompetence> findAllCraftCompetences() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
