package colruyt.pcrsejb.test;


import colruyt.pcrsejb.entity.competence.*;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.privileges.FunctionHoldingPrivilege;
import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.privileges.TeamMemberPrivilege;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.entity.team.Team;
import colruyt.pcrsejb.entity.user.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TestClass {

    User lauraLynn, jos, wouter;
    HashSet<Privilege> teamMemberPriviligeSet;
    TeamMemberPrivilege teamMemberPrivilige;
    Team javaTrainee;
    Function softwareEngineer;
    Role developer, leadDeveloper;
    HashSet<Role> roleSet;
    CraftCompetence emergencyFixes;
    CraftCompetence disasterHandling;
    List<RoleCompetence> craftCompetenceList;

    @BeforeEach
    void setUp() {
        softwareEngineer = new Function("Software Engineer", null,null);
        teamMemberPrivilige = new TeamMemberPrivilege();
        teamMemberPrivilige.setFunction(softwareEngineer);
        lauraLynn = new User("Laura", "Lynn", "LauraLynn@gmail.com", "LauraLynn", null);
        jos = new User("Jos", "Bond", "jos.bond@gmail.com", "JosBond", null );
        wouter = new User("Wouter", "Mosselmans", "wouter.mosselmans@gmail.com", "WouterMosselmans", null);
        teamMemberPriviligeSet = new HashSet<>();
        developer = new Role();
        leadDeveloper = new Role();
    }

    @Test
    void checkIfPrivilegeSetIsEmpty(){
        assertEquals(0, teamMemberPriviligeSet.size());
    }

    @Test
    void checkUserExists(){
        assertEquals("Laura", lauraLynn.getFirstName());
    }

    @Test
    void checkPrivilegeSetHasOnePrivilege(){
        teamMemberPriviligeSet = new HashSet<>();
        teamMemberPriviligeSet.add(teamMemberPrivilige);
        assertEquals(1, teamMemberPriviligeSet.size());
    }

    @Test
    void checkUsersInATeam(){
        //javaTrainee = new Team("Java Trainees", wouter);

    }

    @Test
    void checkIfYouGetAllPrivilegesOfUser(){
        teamMemberPriviligeSet.add(teamMemberPrivilige);
        lauraLynn.setPrivileges(teamMemberPriviligeSet);
        assertEquals(teamMemberPriviligeSet, lauraLynn.getPrivileges());
    }

    @Test
    void checkIfYouGetUsersFunction() {
        teamMemberPriviligeSet.add(teamMemberPrivilige);
        lauraLynn.setPrivileges(teamMemberPriviligeSet);
        Function fhp = null;

        //fhp = lauraLynn.getPrivileges().stream().forEach(p -> ((FunctionHoldingPrivilege)p).getFunction());

        for(Privilege p : lauraLynn.getPrivileges()){
            fhp = ((FunctionHoldingPrivilege)p).getFunction();
        }
        assertEquals(softwareEngineer, fhp);
    }

    @Test
    void checkRolesInFunction(){
        roleSet = new HashSet<>();
        roleSet.add(developer);
        roleSet.add(leadDeveloper);

        softwareEngineer.setRoleSet(roleSet);
        assertEquals(roleSet, softwareEngineer.getRoleSet());
    }

    @Test
    void checkGetAllCraftCompetences(){
        disasterHandling = new CraftCompetence("Disaster Handling", "I can play my role when involved in a disaster situation in a correct way (process), in line with the applicable SLA/SLE and priority, in cooperation with the disaster coördinator/team and other support lines (1st line, expert teams), using the default disaster tools (73111, AdobeConnect,...)");
        emergencyFixes = new CraftCompetence("Emergency Fixes", "I can define, validate and implement a workaround or quick (temporary)  solution (data manipulation, source code adaptation,…) directly in production for an incident that needs a solution, in order to make sure that our PartnerS's processes can run further, using the extra means provided (super userids, emergency paths,...). That means I can also assess the impact of my actions/intervention for my PartnerS' processes and systems.");

        craftCompetenceList = new LinkedList<>();
        craftCompetenceList.add(disasterHandling);
        craftCompetenceList.add(emergencyFixes);
        developer.setRoleCompetenceList(craftCompetenceList);

        assertEquals(craftCompetenceList, developer.getRoleCompetenceList());
    }



    
    //function, get all roles

    //craftcompetence of those roles

    //give me all competences from a function

    //check if there are only functioncompetences

    //check if you can rate a competence

    //consensusrate a competence --> add comment

    //create survey

    //create surveyset --> 3 surveys

    //can i submit a survey?

    //can i get the responsible function person from the function

    //create Operating Unit






}