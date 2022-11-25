
import java.sql.*;
public class DatenbankTest
{ 

    public static void main(String[] args) {
        new DatabaseInterface();
        DatabaseConnector con = new DatabaseConnector("",0,"einkaufsdb.db","","");
        QueryResult res = DatabaseInterface.executeQuery("select produkt, menge from einkaufsliste;");
        if (res != null) {
            for (int i = 0; i < res.getRowCount(); i++) {
                System.out.println("ergebnis: " + res.getData()[i][0] + " " + Integer.parseInt(res.getData()[i][1]));

            }
        }    
        con.close();
    }

}
