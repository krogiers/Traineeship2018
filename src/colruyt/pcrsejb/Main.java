package colruyt.pcrsejb;

import java.util.HashSet;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamManagerPrivilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.bl.TeamServiceBL;
import colruyt.pcrsejb.entity.competence.Competence;


public class Main {

    public static void main(String[] args) {

        TeamServiceBL tsbl = new TeamServiceBL();
        HashSet<Privilege> privileges = new HashSet<>();
        privileges.add(new TeamMemberPrivilege());
        User user = new User("Laura", "Lynn", "laura_lynn@test.com", "test", privileges);
        HashSet<Privilege> privileges2 = new HashSet<>();
        privileges2.add(new TeamMemberPrivilege());
        privileges2.add(new TeamManagerPrivilege());
        User user2 = new User("Wouter", "Mosselmans", "womos@test.com", "test", privileges2);
        Team team = new Team("TEST", user);
        tsbl.addTeamMemberToTeam(user2, team);
        
        team.getEnrollments().forEach(e-> System.out.println(e.getUser().getEmail()));
        
        
    }
}