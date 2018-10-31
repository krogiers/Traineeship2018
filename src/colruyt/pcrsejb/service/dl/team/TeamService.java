package colruyt.pcrsejb.service.dl.team;

import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

public interface TeamService extends GenericCrudService<Team, Long>{

	Team findTeamOfUser(User user);

}
