package colruyt.pcrsejb.service.dl.operatingUnit;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

import colruyt.pcrsejb.entity.operatingunit.OperatingUnit;
import colruyt.pcrsejb.service.dl.DbService;

public class DbOperatingUnitService extends DbService implements OperatingUnitService {

	private static final String GET_ELEMENT = "SELECT * FROM Operatingunits f WHERE ID=?";
	
	@Override
	public OperatingUnit save(OperatingUnit element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OperatingUnit getElement(OperatingUnit element) {
        OperatingUnit operatingUnit = null;
		try (Connection conn = this.createConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(GET_ELEMENT);
            preparedStatement.setInt(1, element.getId());
            ResultSet rs = preparedStatement.executeQuery();
            operatingUnit = convertToSingleOperatingUnit(rs);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return operatingUnit;
    }

	@Override
	public Collection<OperatingUnit> getAllElements() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteElement(OperatingUnit element) {
		// TODO Auto-generated method stub
		
	}
	
	private OperatingUnit convertToSingleOperatingUnit(ResultSet rs) {
		OperatingUnit ou = null;
		try {
			if (rs.next()) {
				ou = new OperatingUnit(rs.getInt("ID"), rs.getString("TITLE"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ou;
	}
   
}
