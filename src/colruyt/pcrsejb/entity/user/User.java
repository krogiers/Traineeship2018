package colruyt.pcrsejb.entity.user;

import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.privileges.Privilege;

import java.util.Set;

public class User {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private Set<Privilege> privileges;
    private Team team;

}
