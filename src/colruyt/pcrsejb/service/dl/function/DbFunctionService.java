package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.competence.FunctionCompetence;
import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.role.Role;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

public class DbFunctionService extends DbService implements FunctionService {


    @Override
    public Function addElement(Function element) {

        try(Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement("INSERT INTO FUNCTIONS(ID, Title, OperatingUnit_ID) " +
                    "VALUES( SELECT MAX(ID) FROM FUNCTIONS, ?, ?)", new String[] {"ID"});
            preparedStatement.setString(1, element.getTitle());
            preparedStatement.setString(2, element.getOperatingUnitId());
            preparedStatement.executeUpdate();
            ResultSet rs = preparedStatement.getResultSet();
            if (rs.next()) {
                element.setFunctionID(rs.getInt("ID"));
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return element;
    }

    @Override
    public Function getElement(Integer index) {
        Function function = null;
        try (Connection conn = this.createConnection()){
            String sql = "SELECT * FROM Functions f WHERE ID=? INNER JOIN FunctionRoles fr ON fr.Functions_ID = f.ID" +
                    " INNER JOIN Competences c ON c.Functions_ID = f.ID";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setInt(1, index);
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
            String sql = "SELECT * FROM Functions f INNER JOIN FunctionRoles fr ON fr.Functions_ID = f.ID" +
                    " INNER JOIN Competences c ON c.Functions_ID = f.ID";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            ResultSet rs = preparedStatement.getResultSet();
            functionList = convertToFunctions(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return functionList;
    }



    @Override
    public void deleteElement(Function element) {
        // TODO
    }


    private Function convertToSingleFunction(ResultSet rs) throws SQLException {
        Function function = null;
        Set<Role> roles;
        Set<FunctionCompetence> functionCompetences;
        while (rs.next()){
            // TODO
            //String name
        }
        return function;
    }

    private List<Function> convertToFunctions(ResultSet rs) {
        List<Function> functionList = new ArrayList<>();
        // TODO
        return functionList;
    }


}
