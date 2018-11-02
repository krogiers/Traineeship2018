package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DbFunctionService extends DbService implements FunctionService {

    private static final String ADD_FUNCTION = "INSERT INTO FUNCTIONS(ID, Title, OperatingUnit_ID) VALUES((SELECT MAX(ID) FROM FUNCTIONS)+1, ?, ?)";
    private static final String GET_ELEMENT = "SELECT * FROM Functions f WHERE ID=?";
    private static final String GET_ALL_ELEMENTS = "SELECT * FROM Functions f INNER JOIN FunctionRoles fr ON fr.Functions_ID = f.ID INNER JOIN Competences c ON c.Functions_ID = f.ID";
    private static final String GET_ALL_FUNCTIONS = "SELECT * FROM Functions";
    private static final String DELETE_FUNCTION = "Delete from Functions where id = ?";
    private static final String UPDATE_FUNCTION = "INSERT into Functions (id,title,OperatingUnits_ID) values (((select max(id) from FUNCTIONS)+1), ?, ?)";

    @Override
    public Function save(Function element) {

        try(Connection conn = this.createConnection()) {
            PreparedStatement statement;

            if(element.getId() != null){
                statement = conn.prepareStatement(UPDATE_FUNCTION, new String[] {"ID"});
            }
            else{
                statement = conn.prepareStatement(ADD_FUNCTION, new String[] {"ID"});
            }
            statement.setString(1, element.getTitle());
            statement.setInt(2, element.getOperatingUnitId());
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                element.setId(rs.getInt("ID"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return element;
    }


    @Override
    public Function getElement(Function function) {
        try (Connection conn = this.createConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
            preparedStatement.setInt(1, function.getId());
            ResultSet rs = preparedStatement.executeQuery();
            function = convertToSingleFunction(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return function;
    }


    @Override
    public Collection<Function> getAllElements() {
        List<Function> functionList = new ArrayList<>();
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_ELEMENTS);
            ResultSet rs = preparedStatement.getResultSet();
            functionList = convertToFunctions(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return functionList;
    }

    @Override
    public List<Function> getAllFunctionNames(){
        List<Function> functionList = new ArrayList<>();
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_FUNCTIONS);
            ResultSet rs = preparedStatement.executeQuery();
            functionList = convertToFunctions(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return functionList;
    }


    @Override
    public void deleteElement(Function element) {
        try(Connection conn = this.createConnection()){

            PreparedStatement statement =  conn.prepareStatement(DELETE_FUNCTION);
            statement.setLong(1,element.getId());
            ResultSet rs =  statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Function convertToSingleFunction(ResultSet rs) throws SQLException {
        Function function = null;
        while (rs.next()){
            function.setId(rs.getInt("ID"));
            function.setTitle(rs.getString("TITLE"));
            function.setOperatingUnitId(rs.getInt("OPERATINGUNITS_ID"));
        }
        return function;
    }

    private List<Function> convertToFunctions(ResultSet rs) throws SQLException {
        List<Function> functionList = new ArrayList<>();

        while (rs.next()) {
            functionList.add(new Function(rs.getInt("ID"), rs.getString("TITLE")));
        }
        return functionList;
    }


}
