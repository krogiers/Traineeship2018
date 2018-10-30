package colruyt.pcrsejb.service.dl.team;

import java.util.ArrayList;
import java.util.Collection;

import colruyt.pcrsejb.entity.team.Team;

public class MemoryTeamService implements AbstractTeamService {

	private ArrayList<Team> db = new ArrayList<>();
	
	
	@Override
	public void addElement(Team team) {
		db.add(team);
	}

	@Override
	public Team getElement(Long index) {
		return this.db.get(index.intValue());
	}

	@Override
	public Collection<Team> getAllElements() {
		return this.db;
	}

	@Override
	public void deleteElement(Team team) {
		this.db.remove(team);
	}

}
