
import java.sql.*;

public class DatabaseInterface
{
    
    private static DatabaseConnector connector;
    
    public DatabaseInterface() {
        
        connector = new DatabaseConnector("", 0, "einkaufsdb.db", "", "");
        
    }
    
    public static DatabaseConnector getConnector() {
        return connector;
    }
    
    public static QueryResult executeQuery(String sql) {
        connector.executeStatement(sql);
        return connector.getCurrentQueryResult();
    }
    
}
