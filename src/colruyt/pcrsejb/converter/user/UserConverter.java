package colruyt.pcrsejb.converter.user;

import java.util.HashSet;

import colruyt.pcrsejb.bo.team.TeamBo;
import colruyt.pcrsejb.bo.user.UserBo;
import colruyt.pcrsejb.bo.userPrivilege.UserPrivilegeBo;
import colruyt.pcrsejb.converter.GenericConverter;
import colruyt.pcrsejb.converter.function.FunctionConverter;
import colruyt.pcrsejb.converter.team.TeamConverter;
import colruyt.pcrsejb.converter.userPrivilege.UserPrivilegeConverter;
import colruyt.pcrsejb.entity.enrolment.Enrolment;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.team.DbTeamService;

/**
 * Class for converting a user Entity into a user BO
 */
public class UserConverter implements GenericConverter<UserBo,User> {


    @Override
    public UserBo convertTo(User from) {
    	UserBo userBo = new UserBo(from.getId(),from.getFirstName(), from.getLastName(), from.getEmail(),
			   from.getPassword(), getPrivileges(from.getPrivileges()), from.getCountry());
    	userBo.setFunctionForFunctionResponsible(null);
    	userBo.setHasActiveAdminRights(false);
    	userBo.setHasInactiveAdminRights(false);
    	FunctionConverter fv = new FunctionConverter();
    	for(UserPrivilege p : from.getPrivileges())
    	{
    		if(p.getPrivilegeType().equals(PrivilegeType.ADMINISTRATOR) && p.isActive())
    		{
    			userBo.setHasActiveAdminRights(true);
    		}
    		if(p.getPrivilegeType().equals(PrivilegeType.ADMINISTRATOR) && !p.isActive())
    		{
    			userBo.setHasInactiveAdminRights(true);
    		}
    		if(p.getPrivilegeType().equals(PrivilegeType.FUNCTIONRESPONSIBLE) && p.isActive())
    		{
    			userBo.setFunctionForFunctionResponsible(fv.convertTo(((FunctionUserPrivilege)p).getFunction()));
    		}
    		if(p.getPrivilegeType().equals(PrivilegeType.TEAMMEMBER) && p.isActive())
    		{
    			userBo.setTeamManager((this.getTeam(from, p)).getTeamManager());
    		}
    	}
       return userBo;
    }
    
    private HashSet<UserPrivilegeBo> getPrivileges(HashSet<UserPrivilege> hashSet) {
    	HashSet<UserPrivilegeBo> privileges = new HashSet<>();
		UserPrivilegeConverter conv = new UserPrivilegeConverter();
    	for (UserPrivilege pr : hashSet) {
    		privileges.add(conv.convertTo(pr));
    	}
    	return privileges;
    }

    private TeamBo getTeam(User user, UserPrivilege p)
    {
    	TeamBo team = null;
    	DbTeamService dbTeamService = new DbTeamService();
    	TeamConverter tc = new TeamConverter();
    	for(Team t : dbTeamService.getAllElements())
    	{
    		for(Enrolment e : t.getEnrolmentsHashSet())
    		{
    			if(e.getUser().equals(user) & e.isActive() & e.getPrivilege().equals(p))
    			{
    				team = tc.convertTo(t);
    			}
    		}
    	}
    	return team;
    }
    
}
