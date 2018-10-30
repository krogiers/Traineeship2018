package colruyt.pcrsejb.service.dl.privilege;

import colruyt.pcrsejb.entity.privileges.*;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.util.factories.ConnectionFactory;
import colruyt.pcrsejb.util.factories.ConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DbPrivilegeService implements PrivilegeService  {


    private Connection createConnection() throws SQLException {
        return ConnectionFactory.createFactory(ConnectionType.BASIC).createConnection();
    }


    @Override
    public void addElement(Privilege element) {

        //TODO:
    }

    @Override
    public Privilege getElement(Integer index) {
        return null;
        //TODO:
    }

    @Override
    public Collection<Privilege> getAllElements() {
        return null;
        //TODO:
    }

    @Override
    public void deleteElement(Privilege element) {

        //TODO:
    }


    @Override
    public List<Privilege> findPrivilegesForUser(User u) {
        List<Privilege> privi = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from userprivileges where user_id = ?");
            statement.setInt(1,u.getId());


            ResultSet rs =  statement.executeQuery();
            privi = convertToPrivilegeList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return privi;

    }


    private List<Privilege> convertToPrivilegeList(ResultSet set) throws SQLException {

        List<Privilege> privileges = new ArrayList<>();
        while(set.next()){
            Privilege p;
            char privilege = set.getString("Privilege").charAt(0);
            p = determineInstance(privilege);
            p.setId(set.getInt("ID"));

            privileges.add(p);
        }
        return privileges;

    }

    private Privilege determineInstance(char type){

        Privilege p = null;
        switch(type){
            case 'T' : p = new TeamManagerPrivilege();break;
            case 'M' : p= new TeamMemberPrivilege();break;
            case 'A' : p = new AdminPrivilege();break;
            case 'F' : p = new FunctionResponsiblePrivilege(); break;
            case 'D' : p = new DirectorPrivilege(); break;
        }

        return p;

    }


    private Privilege convertToSinglePrivilege(ResultSet set) throws SQLException {

        Privilege p = null;
        if(set.next()){

            char privilege = set.getString("Privilege").charAt(0);
            p = determineInstance(privilege);
            p.setId(set.getInt("ID"));
        }

        return p;
    }
}
