package colruyt.pcrsejb.service.dl.competence;

import colruyt.pcrsejb.entity.competence.Competence;

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
	public Competence getElement(Competence competence) {
		return db.get((competence.getCompetenceID()));
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
	public Collection<Competence> findAllFunctionCompetences() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Collection<Competence> findAllCraftCompetences() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
