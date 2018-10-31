package colruyt.pcrsejb.util.factories;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


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
			Properties prop = new Properties();
			InputStream input = null;
			try {
				input = new FileInputStream("config.properties");

				// load a properties file
				prop.load(input);

				// get the property value
				userId = prop.getProperty("userId");
				passwd = prop.getProperty("passwd");
				url = prop.getProperty("url");
			} catch (IOException ex) {
				ex.printStackTrace();
			} finally {
				if (input != null) {
					try {
						input.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
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
