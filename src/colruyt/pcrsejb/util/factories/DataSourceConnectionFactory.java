package colruyt.pcrsejb.util.factories;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSourceConnectionFactory extends ConnectionFactory {

	private static DataSourceConnectionFactory instance;
	// fill in the correct JNDI name instead of XXX !
	private static String jndiName="XXX";

	private DataSourceConnectionFactory() {

	}

	public static DataSourceConnectionFactory getInstance() {
		if (instance == null) {
			instance = new DataSourceConnectionFactory();
		}
		return instance;
	}
	

	@Override
	public Connection createConnection() throws SQLException {
		Connection conn = null;
		Context ctx;
		try {
			ctx = new InitialContext();
			
			DataSource ds = (DataSource) ctx.lookup(jndiName);
			
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		}

		return conn;
	}

}
