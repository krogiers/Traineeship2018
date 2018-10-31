package colruyt.pcrsejb.service.dl;

import colruyt.pcrsejb.util.factories.ConnectionFactory;
import colruyt.pcrsejb.util.factories.ConnectionType;

import java.sql.Connection;
import java.sql.SQLException;

public abstract class DbService {

    public Connection createConnection() throws SQLException {
        return ConnectionFactory.createFactory(ConnectionType.BASIC).createConnection();
    }
}
