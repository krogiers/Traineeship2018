package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;
import colruyt.pcrsejb.service.dl.DbService;
import colruyt.pcrsejb.service.dl.operatingUnit.DbOperatingUnitService;
import colruyt.pcrsejb.service.dl.operatingUnit.OperatingUnitService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public class DbFunctionService extends DbService implements FunctionService {
	private OperatingUnitService operatingUnitService = new DbOperatingUnitService();

    private static final String ADD_FUNCTION = "INSERT INTO FUNCTIONS(ID, Title, OperatingUnit_ID) VALUES((SELECT MAX(ID) FROM FUNCTIONS)+1, ?, ?)";
    private static final String GET_ELEMENT = "SELECT * FROM Functions f WHERE ID=?";
    private static final String GET_ALL_ELEMENTS = "SELECT * FROM FUNCTIONS f inner join FUNCTIONROLES fr on fr.FUNCTIONS_ID = f.ID inner join COMPETENCES C on f.ID = C.FUNCTIONS_ID";
    private static final String GET_ALL_FUNCTIONS = "SELECT f.ID AS FUNCTION_ID, f.title AS FUNCTION_TITLE, ou.id AS OPERATING_UNIT_ID, ou.title AS OPERATING_UNIT_NAME FROM Functions f INNER JOIN OperatingUnits ou ON ou.id = f.OperatingUnits_id";
    private static final String DELETE_FUNCTION = "Delete FROM Functions WHERE id = ?";
    private static final String UPDATE_FUNCTION = "INSERT INTO Functions (id,title,OperatingUnits_ID) values (((select max(id) from FUNCTIONS)+1), ?, ?)";

    @Override
    public Function save(Function element) {

        try (Connection conn = this.createConnection()) {
            PreparedStatement statement;

            if (element.getId() != null) {
                statement = conn.prepareStatement(UPDATE_FUNCTION, new String[]{"ID"});
            } else {
                statement = conn.prepareStatement(ADD_FUNCTION, new String[]{"ID"});
            }
            statement.setString(1, element.getTitle());
            statement.setInt(2, element.getOperatingUnit().getId());
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
        try (Connection conn = this.createConnection()) {
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
    public List<Function> getAllFunctionNames() {
        List<Function> functionList = new ArrayList<>();
        try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ALL_FUNCTIONS);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                OperatingUnit ou = new OperatingUnit(rs.getInt("OPERATING_UNIT_ID"), rs.getString("OPERATING_UNIT_NAME"));
                functionList.add(new Function(rs.getInt("FUNCTION_ID"), rs.getString("FUNCTION_TITLE"), ou));
            }

            //functionList = convertToFunctions(rs);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return functionList;
    }


    @Override
    public void deleteElement(Function element) {
        try (Connection conn = this.createConnection()) {

            PreparedStatement statement = conn.prepareStatement(DELETE_FUNCTION);
            statement.setLong(1, element.getId());
            ResultSet rs = statement.executeQuery();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Function convertToSingleFunction(ResultSet rs) throws SQLException {
        Function function = null;
        if (rs.next()) {
            function = new Function();
            function.setId(rs.getInt("ID"));
            function.setTitle(rs.getString("TITLE"));
            function.setOperatingUnit(operatingUnitService.getElement(new OperatingUnit(rs.getInt("OPERATINGUNITS_ID"))));
            //TODO get Roles to function
            function.setRoleSet(new HashSet<>());
            //TODO getFunctionCompetencesRoleSet
            function.setFunctionCompetenceSet(new HashSet<>());

        }
        return function;
    }

    private List<Function> convertToFunctions(ResultSet rs) throws SQLException {
        List<Function> functionList = new ArrayList<>();
        while (rs.next()) {
            //TODO add roles & operating unit
            functionList.add(new Function(rs.getInt("FUNCTION_ID"), rs.getString("FUNCTION_TITLE"), operatingUnitService.getElement(new OperatingUnit(rs.getInt("OPERATINGUNITS_ID")))));
        }
        return functionList;
    }


}
