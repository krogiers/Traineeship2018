package colruyt.pcrsejb.service.dl.NOTBEINGUSEDANYMOREprivilege;

import colruyt.pcrsejb.entity.DONOTUSEANYMOREprivileges.*;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;



public class DbPrivilegeService  extends DbService implements PrivilegeService  {

    private static final String ADD_PRIVILEGE = "INSERT into privis (id, fullname, shortname) values ((select max(id) from privis)+1,?,?)";
    private static final String UPDATE_PRIVILEGE = "INSERT into privis (id, fullname, shortname) values (((select max(id) from privis)+1), ?, ?)";
    private static final String GET_ELEMENT = "Select  * from privis where id = ?";
    private static final String GET_ALL_ELEMENTS = "Select * from privis";
    private static final String DELETE_ELEMENT = "Delete from privis where id = ?" ;


    @Override
    public Privilege save(Privilege element) {

        try(Connection conn = this.createConnection()){
            PreparedStatement statement;

            if(element.getId() != null){
                statement = conn.prepareStatement(UPDATE_PRIVILEGE, new String[] {"ID"});
            }
            else{
                statement = conn.prepareStatement(ADD_PRIVILEGE, new String[] {"ID"});
            }

            statement.setString(1,""); //fullname
            statement.setString(2, ""); //shortname

            statement.executeUpdate();
            ResultSet rs = statement.getGeneratedKeys();

            if(rs.next()) {
                element.setId(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return element;
    }


    @Override
    public Privilege getElement(Privilege privilege) {
        try(Connection conn = this.createConnection()){
            PreparedStatement statement =  conn.prepareStatement(GET_ELEMENT);
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

            PreparedStatement statement =  conn.prepareStatement(GET_ALL_ELEMENTS);

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
            PreparedStatement statement =  conn.prepareStatement(DELETE_ELEMENT);
            statement.setLong(1,element.getId());
            statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



    //TODO BEKIJK DEZE METHODS





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

    //    private char reverseTypeing(Privilege privi){
//
//            char e = 'V';
//            switch(privi.getClass().getSimpleName()){
//
//                case "TeamManagerPrivilege" : e = 'M';break;
//                case "TeamMemberPrivilege" : e = 'T';break;
//                case "AdminPrivilege" : e = 'A';break;
//                case "FunctionResponsiblePrivilege" : e='F'; break;
//                case  "DirectorPrivilege" : e = 'D'; break;
//            }
//
//            return e;
//    }

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
