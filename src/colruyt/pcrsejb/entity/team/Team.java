package colruyt.pcrsejb.entity.team;

import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.user.privileges.Privilege;

import java.util.Map;

public class Team {

    private String name;
    private Map<User, Privilege> teamMembersMap;

}
