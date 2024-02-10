import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Connection;
//class for database connection
public class DbConnector {
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/student";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";
    public static Connection connect1() throws SQLException{

       return DriverManager.getConnection(JDBC_URL,USERNAME,PASSWORD);
    }

}
