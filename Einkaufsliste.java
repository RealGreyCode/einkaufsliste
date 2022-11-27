
import java.util.*;
import java.sql.*;

public class Einkaufsliste
{

    public final int id;
    
    public Einkaufsliste(int id) {
        this.id = id;
    }
    
    public String gibTitel() {
        QueryResult result = DatabaseInterface.executeQuery("SELECT `titel` FROM `einkaufslisten` WHERE `id` = " + this.id + ";");
        if(result.getRowCount() > 0) 
            return result.getData()[0][0]; 
        return null;
    }
    
    public Map<Produkt, Integer> gibProdukte() {
        QueryResult result = DatabaseInterface.executeQuery("SELECT `produkt_id`, `menge` FROM `listeneintraege` WHERE `listen_id` = " + this.id + ";");
        Map<Produkt, Integer> produkte = new HashMap<>();

        for(String[] row : result.getData()) {
            int produktID = Integer.parseInt(row[0]);
            int menge = Integer.parseInt(row[1]);

            Produkt produkt = new Produkt(produktID);

            produkte.put(produkt, menge);
        }
        return produkte;
    }
    
}
