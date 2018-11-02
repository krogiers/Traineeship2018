package colruyt.pcrsejb.service.dl.privilege;

import colruyt.pcrsejb.entity.privileges.*;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.util.factories.ConnectionFactory;
import colruyt.pcrsejb.util.factories.ConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class DbPrivilegeService  extends DbService implements PrivilegeService  {


    @Override
    public Privilege save(Privilege element) {

        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("INSERT into privis (id,shortname,fullname) values ((select max(id) from users)+1),?,?)");



            statement.setLong(1,element.getId());
            statement.setString(2,this.reverseTypeing(element) + "");
            statement.setString(3,element.getClass().getSimpleName());


            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                element.setId((int) rs.getLong(1));
                return element;
            }
            else {
                throw new IllegalArgumentException();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //TODO: Standaarden
        return null;

    }




    private char reverseTypeing(Privilege privi){

            char e = 'V';
            switch(privi.getClass().getSimpleName()){

                case "TeamManagerPrivilege" : e = 'M';break;
                case "TeamMemberPrivilege" : e = 'T';break;
                case "AdminPrivilege" : e = 'A';break;
                case "FunctionResponsiblePrivilege" : e='F'; break;
                case  "DirectorPrivilege" : e = 'D'; break;
            }

            return e;


    }

    @Override
    //TODO: Fix --> moet Index E werden (Char van privilege)
    public Privilege getElement(Privilege privilege) {
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select  * from privis where id = ?");
            statement.setInt(1,privilege.getId());
            ResultSet rs =  statement.executeQuery();
            privilege = convertToSinglePrivilege(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privilege;
    }

    @Override
    public Collection<Privilege> getAllElements() {
        List<Privilege> privileges = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from privis");

            ResultSet rs =  statement.executeQuery();
            privileges = convertToPrivilegeList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return privileges;
    }

    @Override
    public void deleteElement(Privilege element) {

        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Delete from privis where id = ?");
            statement.setLong(1,element.getId());
            ResultSet rs =  statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }





    private List<Privilege> convertToPrivilegeList(ResultSet set) throws SQLException {

        List<Privilege> privileges = new ArrayList<>();
        while(set.next()){
            Privilege p;
            char privilege = set.getString("shortname").charAt(0);
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

            char privilege = set.getString("shortname").charAt(0);
            p = determineInstance(privilege);
            p.setId(set.getInt("ID"));

        }

        return p;
    }
}
