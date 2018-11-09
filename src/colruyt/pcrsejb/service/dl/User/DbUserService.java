package colruyt.pcrsejb.service.dl.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.user.User;
import colruyt.pcrsejb.entity.userPrivilege.FunctionResponsibleUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.PrivilegeType;
import colruyt.pcrsejb.entity.userPrivilege.TeamMemberUserPrivilege;
import colruyt.pcrsejb.entity.userPrivilege.UserPrivilege;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.function.DbFunctionService;
import colruyt.pcrsejb.service.dl.function.FunctionService;

public class DbUserService extends DbService implements UserService {
	
	FunctionService fs = new DbFunctionService();

    private static final String FIND_USER_BY_ID = "Select * from Users where id = ?";
    private static final String FIND_USERS_BY_PRIVILIGE = "Select * from Users u inner join UserPrivileges up on u.id = up.user_id  where up.privis_id = ? and active=1";
    private static final String FIND_USERS_BY_FIRSTNAME = "Select * from Users where firstname = ?";
    private static final String FIND_USERS_BY_SHORTNAME = "Select * from Users where UPPER(Firstname) like UPPER(?) and UPPER(Lastname) like UPPER(?)";
    private static final String FIND_ALL_USERS = "Select * from Users";
    private static final String INSERT_USER = "INSERT into Users (id,firstname,lastname,password,email, homecountry) values (((select max(id) from users)+1),?,?,?,?,?)";
    private static final String UPDATE_USER = "UPDATE Users SET firstname = ?, lastname = ?, password = ?, email = ?, homecountry = ? WHERE ID = ?";
    private static final String ADD_PRIVILIGE_TO_USER = "INSERT into UserPrivileges values ( ( SELECT MAX(ID) FROM UserPrivileges) + 1,?,?,?,?,?)";
    private static final String UPDATE_PRIVILIGE_TO_USER = "UPDATE UserPrivileges SET User_ID = ?, Functions_ID = ?, Active = ?, email = ?, country = ?, Privis_ID WHERE ID = ?" ;
    private static final String FIND_PRIVILEGES_OF_USER = "Select * from userprivileges where user_id = ?";
    private static final String DELETE_USER = "Delete from Users where id = ?" ;
    private static final String FIND_FUNCTION_RESPONSIBLE = "Select * from Users u inner join UserPrivileges up on u.id = up.user_id where " +
            "up.privis_id=? and active=1 and functions_id=? and country=?";


    @Override
    public List<User> findUsersByPrivilege(UserPrivilege privilege) {
        List<User> users = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_USERS_BY_PRIVILIGE);
            statement.setInt(1, privilege.getPrivilegeType().getId());
            ResultSet rs =  statement.executeQuery();
            users = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }

    @Override
    public List<User> getFunctionResponsible(int functionId, String country){
        List<User> users = new ArrayList<>();
        try (Connection conn = this.createConnection()) {
            PreparedStatement statement =  conn.prepareStatement(FIND_FUNCTION_RESPONSIBLE);
            statement.setInt(1, PrivilegeType.FUNCTIONRESPONSIBLE.getId());
            statement.setInt(2, functionId);
            statement.setString(3, country);
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


    private void addPrivilegesToUser(UserPrivilege priv, User user){
        try(Connection conn = this.createConnection()){
            Integer functionId = null;
            String country = null;

            if (PrivilegeType.TEAMMEMBER == priv.getPrivilegeType()) {
            	//TODO Save the date
            	functionId = ((TeamMemberUserPrivilege) priv).getFunction().getId();
            }
            else if(PrivilegeType.FUNCTIONRESPONSIBLE == priv.getPrivilegeType()) {
            	functionId = ((FunctionResponsibleUserPrivilege) priv).getFunction().getId();
            	country = ((FunctionResponsibleUserPrivilege) priv).getCountry();
            }

            PreparedStatement statement;

            if(priv.getId() != null){
                statement =  conn.prepareStatement(UPDATE_PRIVILIGE_TO_USER, new String[] {"ID"});
            }
            else{
                statement =  conn.prepareStatement(ADD_PRIVILIGE_TO_USER, new String[] {"ID"});
            }

            statement.setInt(1, user.getId());
            statement.setInt(2, functionId);
            statement.setInt(3, priv.isActive() ? 1 : 0); // active
            statement.setString(4, country);
            statement.setInt(5, priv.getId());

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

            User user = new User(id,firstname,lastname,password,email,new HashSet<UserPrivilege>(), country);
            user.setPrivileges(new HashSet<>(this.findPrivilegesForUser(user)));

            userList.add(user);
        }
        return userList;
    }


    public User convertToSingleUser(ResultSet rs) throws SQLException {

        User user =  null;
        if(rs.next()){
            int id = rs.getInt("id");
            String firstname = rs.getString("firstname");
            String lastname = rs.getString("lastname");
            String password = rs.getString("password");
            String email = rs.getString("email");
            String country = rs.getString("homecountry");

            user = new User(id,firstname,lastname,password,email,new HashSet<UserPrivilege>(), country);
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

                for(UserPrivilege priv: user.getPrivileges()){
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

            PreparedStatement statement =  conn.prepareStatement(FIND_USER_BY_ID);
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

            PreparedStatement statement =  conn.prepareStatement(FIND_ALL_USERS);

            ResultSet rs =  statement.executeQuery();
            users = convertToUserList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }



    private List<UserPrivilege> findPrivilegesForUser(User u) {
        List<UserPrivilege> privi = new ArrayList<>();
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(FIND_PRIVILEGES_OF_USER);

            statement.setInt(1,u.getId());

            ResultSet rs =  statement.executeQuery();
            privi = convertToUserPrivilegeList(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return privi;

    }

    private List<UserPrivilege> convertToUserPrivilegeList(ResultSet set) throws SQLException {

        List<UserPrivilege> privileges = new ArrayList<>();
        while(set.next()){
            PrivilegeType type = determinePrivilegeType(set.getInt("PRIVIS_ID"));
            UserPrivilege p;
            if (PrivilegeType.TEAMMEMBER == type) {
            	//TODO GET DATE from database
            	p = new TeamMemberUserPrivilege(type, "1".equals(set.getInt("ACTIVE")), fs.getElement(new Function(set.getInt("FUNCTIONS_ID"))), null);
            }
            else if(PrivilegeType.FUNCTIONRESPONSIBLE == type) {
            	p = new FunctionResponsibleUserPrivilege(type, "1".equals(set.getInt("ACTIVE")), fs.getElement(new Function(set.getInt("FUNCTIONS_ID"))), set.getString("COUNTRY"));
            }
            else {
            	p = new UserPrivilege(type, "1".equals(set.getInt("ACTIVE")));
            }
            privileges.add(p);
        }
        return privileges;

    }

    private PrivilegeType determinePrivilegeType(Integer typeId){
        PrivilegeType p = null;
        for (PrivilegeType pt : PrivilegeType.values()) {
        	if (pt.getId() == typeId) {
        		p = pt;
        	}
        }
        return p;
    }

    @Override
    public void deleteElement(User element) {
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(DELETE_USER);
            statement.setLong(1,element.getId());
            ResultSet rs =  statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}