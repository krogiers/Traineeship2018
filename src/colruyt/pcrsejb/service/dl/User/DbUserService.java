package colruyt.pcrsejb.service.dl.User;

import colruyt.pcrsejb.entity.privileges.Privilege;
import colruyt.pcrsejb.entity.user.User;
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



    private Connection createConnection() throws SQLException {
      return ConnectionFactory.createFactory(ConnectionType.BASIC).createConnection();
    }

    @Override
    public List<User> findUsersByPrivilege(Privilege privilege) {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users u inner join UserPrivileges up on u.id = up.id  where up.id = ?");
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

    private List<User> convertToUserList(ResultSet rs) throws SQLException {

        List<User> user = new ArrayList<User>();
        while(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");


            user.add(new User(id,firstname,lastname,password,email,new HashSet<Privilege>()));
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

            //TODO: Privilege toevoegne (Inner join ?)
            u = new User(id,firstname,lastname,password,email,new HashSet<Privilege>());
        }
        return u;
    }


    @Override
    public void addElement(User element) {
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("INSERT into user (id,firstname,lastname,password,email) values (?,?,?,?,?)");
            statement.setInt(1,element.getId());
            statement.setString(2,element.getFirstName());
            statement.setString(3,element.getLastName());
            statement.setString(4,element.getEmail());
            statement.setString(5,element.getEmail());

            statement.setLong(1,element.getId());
            ResultSet rs =  statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    @Override
    public User getElement(Long index) {
        User user = null;
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement("Select * from Users where id = ?");
            statement.setLong(1,index);


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
