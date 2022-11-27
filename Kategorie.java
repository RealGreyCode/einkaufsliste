
/**
 * Write a description of class Kategorie here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Kategorie 
{
    
    public final int id;
    
    public Kategorie(int id) {
        this.id = id;
    }
    
    public String gibBezeichnung() {
        QueryResult result = DatabaseInterface.executeQuery("SELECT `bezeichnung` FROM `kategorien` WHERE `id` = " + this.id);
		if(result.getRowCount() > 0)
			return result.getData()[0][0];
		return null;
    }
    
}
