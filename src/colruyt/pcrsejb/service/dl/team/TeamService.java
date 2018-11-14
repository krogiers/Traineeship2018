package colruyt.pcrsejb.service.dl.team;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.GenericCrudService;

import java.util.List;

public interface TeamService extends GenericCrudService<Team, Long>{

	Team findTeamOfUser(User user);

    Team findTeamOfEnrolments(Enrolment e);
}
