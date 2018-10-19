package colruyt.pcrsejb.dl.competence;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import colruyt.pcrsejb.entity.competence.Competence;

public class MemoryCompetenceService implements AbstractCompetenceService {

	private List<Competence> db = new ArrayList<>();
	
	@Override
	public void addElement(Competence element) {
		db.add(element);
		
	}

	@Override
	public Competence getElement(Long index) {
		return this.db.get((index.intValue()));
	}

	@Override
	public List<Competence> getAllElements() {
		
		return this.db;
	}

	@Override
	public void deleteElement(Competence element) {
		this.db.remove(element);
		
	}

	

}
