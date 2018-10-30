package colruyt.pcrsejb.util.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class BasicConnectionFactory extends ConnectionFactory {
	
    // fill in the correct connection info instead of XXX
	private static String userId="XXX";
	private static String passwd="XXX";
	private static String url="XXX";


	private static BasicConnectionFactory instance;
	
    private BasicConnectionFactory(){
    	
    }
    
    public static BasicConnectionFactory getInstance(){
		if (instance==null){
			instance=new BasicConnectionFactory();
		}
		return instance;
	}
    
	@Override
	public Connection createConnection() throws SQLException {
		Connection conn = DriverManager.getConnection(url, userId, passwd);
		//System.out.println("connection via DriverManager");
		return conn;
	}

	

}
