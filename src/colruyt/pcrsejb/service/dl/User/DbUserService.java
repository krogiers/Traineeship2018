package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.privileges.*;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.privilege.DbPrivilegeService;
import colruyt.pcrsejb.service.dl.privilege.PrivilegeService;
import colruyt.pcrsejb.util.factories.ConnectionFactory;
import colruyt.pcrsejb.util.factories.ConnectionType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DbUserService extends DbService implements UserService {



    @Override
    public List<User> findUsersByPrivilege(Privilege privilege) {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users u inner join " +
                    "UserPrivileges up on u.id = up.user_id  where up.privileges_id = ? and active=1");
          statement.setInt(1, privilege.getId());
          ResultSet rs =  statement.executeQuery();
          users = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findUsersByFirstName(String name) {

        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

           PreparedStatement statement =  conn.prepareStatement("Select * from Users where fname = ?");
           statement.setString(1,name);
           ResultSet rs =  statement.executeQuery();
           users = convertToUserList(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> findUsersByShortName(String shortName) {
        System.out.println("Searching on short name " + shortName);
       List<User> lijst = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users where " +
                    "UPPER(Firstname) like ? and UPPER(Lastname) like ?");

            String firstname = shortName.substring(0,2).toUpperCase();
            String lastname = shortName.substring(2).toUpperCase();
            System.out.println(firstname);
            System.out.println(lastname);
            statement.setString(1,firstname + "%");
            statement.setString(2,lastname + "%");


            ResultSet rs =  statement.executeQuery();
            lijst = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lijst;
    }



    @Override
    public void addPrivilegesToUser(Privilege privi, User user){
        try(Connection conn = this.createConnection()){
            Integer functionId = null;
            String country = null;

            if (privi instanceof FunctionHoldingPrivilege) {
                functionId = ((FunctionHoldingPrivilege) privi).getFunction().getFunctionID();
                if (privi instanceof FunctionResponsiblePrivilege){
                    country = ((FunctionResponsiblePrivilege) privi).getCountry();
                }
            }

            System.out.println(user.getId() + " " + functionId + " " + country + " " + privi.getId());

            String sql = "INSERT into UserPrivileges values ( ( SELECT MAX(ID) FROM UserPrivileges) + 1,?,?,?,?,?)";
            PreparedStatement statement =  conn.prepareStatement(sql);

            statement.setInt(1, user.getId());
            statement.setInt(2, functionId);
            statement.setInt(3, 1);
            statement.setString(4, country);
            statement.setInt(5, privi.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<User> convertToUserList(ResultSet rs) throws SQLException {

        List<User> user = new ArrayList<User>();
        while(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            User u = new User(id,firstname,lastname,password,email,new HashSet<Privilege>(), country);
            u.setPrivileges(new HashSet<>(this.findPrivilegesForUser(u)));

            user.add(u);
        }
        return user;
    }


    private User convertToSingleUser(ResultSet rs) throws SQLException {

        User u =  null;
        if(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            u = new User(id,firstname,lastname,password,email,new HashSet<Privilege>(), country);
            u.setPrivileges(new HashSet<>(this.findPrivilegesForUser(u)));
        }
        return u;
    }


    @Override
    public User addElement(User element) {

        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("INSERT into Users " +
                    "(id,firstname,lastname,password,email) values (((select max(id) from users)+1),?,?,?,?,?)");

            statement.setString(1,element.getFirstName());
            statement.setString(2,element.getLastName());
            statement.setString(3,element.getEmail());
            statement.setString(4,element.getPassword());
            statement.setString(5, element.getCountry());

            //statement.setLong(1,element.getId());
            statement.executeUpdate();

            ResultSet rs =  statement.getGeneratedKeys();

            if(rs.next()) {
                element.setId((int) rs.getLong(1));

                for(Privilege e: element.getPrivileges()){

                    this.addPrivilegesToUser(e,element);

                }
            }
            else
            throw new IllegalArgumentException();

            return element;



        } catch (SQLException e) {
            e.printStackTrace();
        }
            //TODO: Maak BEter
            return null;
    }

    @Override
    public User getElement(Integer index) {
        User user = null;
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users where id = ?");
            statement.setInt(1,index);


            ResultSet rs =  statement.executeQuery();
            user = convertToSingleUser(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return user;
    }

    @Override
    public Collection<User> getAllElements() {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users");

            ResultSet rs =  statement.executeQuery();
            users = convertToUserList(rs);


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }



    private List<Privilege> findPrivilegesForUser(User u) {
        List<Privilege> privi = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from userprivileges up inner join privis ps " +
                    "on up.privileges_id = ps.id LEFT OUTER JOIN Functions f ON f.id = up.functions_id  where user_id = ?");

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
            char privilege = set.getString("shortname").charAt(0);
            p = determineInstance(privilege);
            p.setId(set.getInt("PRIVILEGES_ID"));


            if (set.getString("COUNTRY") != null) {
                ((FunctionResponsiblePrivilege) p).setFunction(
                        new Function(set.getInt("Functions_id"), set.getString("title"))
                );
            }
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


    @Override
    public void deleteElement(User element) {

        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Delete from Users where id = ?");
            statement.setLong(1,element.getId());
            ResultSet rs =  statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }




    }

}
