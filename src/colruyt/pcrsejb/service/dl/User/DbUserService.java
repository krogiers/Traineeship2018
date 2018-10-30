package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
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

public class DbUserService implements UserService {


    private PrivilegeService service = new DbPrivilegeService();

    private Connection createConnection() throws SQLException {
      return ConnectionFactory.createFactory(ConnectionType.BASIC).createConnection();
    }

    @Override
    public List<User> findUsersByPrivilege(Privilege privilege) {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users u inner join UserPrivileges up on u.id = up.user_id  where up.id = ?");
          statement.setInt(1,privilege.getId());
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

       List<User> lijst = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users where Firstname like ? and Lastname like ?");

            String firstname = shortName.substring(0,2);
            String lastname = shortName.substring(2);
            statement.setString(1,firstname + "%");
            statement.setString(2,lastname + "%");


            ResultSet rs =  statement.executeQuery();
            lijst = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lijst;
    }

    private List<User> convertToUserList(ResultSet rs) throws SQLException {

        List<User> user = new ArrayList<User>();
        while(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");


            User u = new User(id,firstname,lastname,password,email,new HashSet<Privilege>());
            u.setPrivileges(new HashSet<>(service.findPrivilegesForUser(u)));

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

            u = new User(id,firstname,lastname,password,email,new HashSet<Privilege>());
            u.setPrivileges(new HashSet<>(service.findPrivilegesForUser(u)));
        }
        return u;
    }


    @Override
    public User addElement(User element) {

        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("INSERT into user (id,firstname,lastname,password,email) values (?,?,?,?,?)");

            statement.setString(2,element.getFirstName());
            statement.setString(3,element.getLastName());
            statement.setString(4,element.getEmail());
            statement.setString(5,element.getPassword());

            statement.setLong(1,element.getId());
            statement.executeQuery();
            ResultSet rs =  statement.getGeneratedKeys();

            if(rs.next())
            element.setId((int) rs.getLong(1));
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
