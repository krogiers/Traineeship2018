package colruyt.pcrsejb.service.dl.enrolment;

import java.util.HashSet;
import java.util.List;

import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.GenericCrudService;

public interface EnrolmentService extends GenericCrudService<Enrolment,Integer>{

	HashSet<Enrolment> getEnrolmentsForTeam(Team team);

    List<Enrolment> getEnrolmentsForPrivilege(UserPrivilege managerPrivilege);
}