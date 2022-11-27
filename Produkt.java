
/**
 * Beschreiben Sie hier die Klasse Produkt.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Produkt
{
    
    public final int id;

    public Produkt(int id) {
        this.id = id;
    }

    public String gibBezeichnung() {
        QueryResult result = DatabaseInterface.executeQuery("SELECT `bezeichnung` FROM `produkte` WHERE `id` = " + this.id);
        if(result.getRowCount() > 0)
            return result.getData()[0][0];
        return null;
    }
    
    public Kategorie gibKategorie() {
        QueryResult result = DatabaseInterface.executeQuery("SELECT `kategorie_id` FROM `produkte` WHERE `id` = " + this.id);
        if (result.getRowCount() > 0)
            return new Kategorie(Integer.parseInt(result.getData()[0][0]));
        return null;
    }

}
