package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.privileges.*;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DbUserService extends DbService implements UserService {

    private static final String FIND_USERS_BY_PRIVILIGE = "Select * from Users u inner join UserPrivileges up on u.id = up.user_id  where up.privis_id = ? and active=1";
    private static final String FIND_USERS_BY_FIRSTNAME = "Select * from Users where firstname = ?";
    private static final String FIND_USERS_BY_SHORTNAME = "Select * from Users where UPPER(Firstname) like UPPER(?) and UPPER(Lastname) like UPPER(?)";
    private static final String ADD_PRIVILIGE_TO_USER = "INSERT into UserPrivileges values ( ( SELECT MAX(ID) FROM UserPrivileges) + 1,?,?,?,?,?)";
    private static final String INSERT_USER = "INSERT into Users (id,firstname,lastname,password,email, homecountry) values (((select max(id) from users)+1),?,?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE Users SET firstname = ?, lastname = ?, password = ?, email = ?, homecountry = ? WHERE ID = ?";
    private static final String UPDATE_PRIVILIGE_TO_USER = "" ;


    @Override
    public List<User> findUsersByPrivilege(Privilege privilege) {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_USERS_BY_PRIVILIGE);
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

           PreparedStatement statement =  conn.prepareStatement(FIND_USERS_BY_FIRSTNAME);
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
       List<User> userList = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_USERS_BY_SHORTNAME);

            String firstname = shortName.substring(0,2).toUpperCase();
            String lastname = shortName.substring(2).toUpperCase();
            statement.setString(1,firstname + "%");
            statement.setString(2,lastname + "%");


            ResultSet rs =  statement.executeQuery();
            userList = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return userList;
    }


    private void addPrivilegesToUser(Privilege privi, User user){
        try(Connection conn = this.createConnection()){
            Integer functionId = null;
            String country = null;

            if (privi instanceof FunctionHoldingPrivilege) {
                functionId = ((FunctionHoldingPrivilege) privi).getFunction().getFunctionID();
                if (privi instanceof FunctionResponsiblePrivilege){
                    country = ((FunctionResponsiblePrivilege) privi).getCountry();
                }
            }

            PreparedStatement statement;

            if(privi.getId() != null){
                statement =  conn.prepareStatement(UPDATE_PRIVILIGE_TO_USER, new String[] {"ID"});
            }
            else{
                statement =  conn.prepareStatement(ADD_PRIVILIGE_TO_USER, new String[] {"ID"});
            }

            statement.setInt(1, user.getId());
            statement.setInt(2, functionId);
            statement.setInt(3, 1); // active
            statement.setString(4, country);
            statement.setInt(5, privi.getId());

            statement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private List<User> convertToUserList(ResultSet rs) throws SQLException {

        List<User> userList = new ArrayList<User>();

        while(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            User user = new User(id,firstname,lastname,password,email,new HashSet<Privilege>(), country);
            user.setPrivileges(new HashSet<>(this.findPrivilegesForUser(user)));

            userList.add(user);
        }
        return userList;
    }


    private User convertToSingleUser(ResultSet rs) throws SQLException {

        User user =  null;
        if(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            user = new User(id,firstname,lastname,password,email,new HashSet<Privilege>(), country);
            user.setPrivileges(new HashSet<>(this.findPrivilegesForUser(user)));
        }
        return user;
    }


    @Override
    public User save(User user) {

        try(Connection conn = this.createConnection()){
            PreparedStatement statement;

            if(user.getId() != null){
                statement = conn.prepareStatement(UPDATE_USER, new String[] {"ID"});

            }
            else{
                statement = conn.prepareStatement(INSERT_USER, new String[] {"ID"});
            }

            statement.setString(1,user.getFirstName());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getEmail());
            statement.setString(4,user.getPassword());
            statement.setString(5, user.getCountry());
            statement.executeUpdate();

            ResultSet rs =  statement.getGeneratedKeys();

            if(rs.next()) {
                user.setId(rs.getInt("ID"));

                for(Privilege priv: user.getPrivileges()){
                    addPrivilegesToUser(priv, user);
                }
            }
        } catch (SQLException e) {
            //TODO throw exception!
            user = null;
            e.printStackTrace();

        }
        return user;
    }

    @Override
    public User getElement(User user) {
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users where id = ?");
            statement.setInt(1,user.getId());


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
                    "on up.privis_id = ps.id LEFT OUTER JOIN Functions f ON f.id = up.functions_id  where user_id = ? ");

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
            p.setId(set.getInt("PRIVIS_ID"));

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
