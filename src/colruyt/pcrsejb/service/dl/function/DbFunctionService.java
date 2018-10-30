package colruyt.pcrsejb.service.dl.function;

import colruyt.pcrsejb.entity.function.Function;
import colruyt.pcrsejb.service.dl.DbService;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

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
        try (Connection conn = this.createConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT * FROM FUNCTIONS WHERE ID=?");
            preparedStatement.setInt(1, index);
            ResultSet rs = preparedStatement.executeQuery();
            convertToSingleFunction(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }



    @Override
    public Collection<Function> getAllElements() {
        return null;
    }

    @Override
    public void deleteElement(Function element) {
        // TODO
    }


    private void convertToSingleFunction(ResultSet rs) throws SQLException {
        // TODO

    }

}
