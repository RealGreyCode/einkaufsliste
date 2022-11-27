import java.util.*;
/**
 * Beschreiben Sie hier die Klasse Benutzer.
 * 
 * @author (Ihr Name) 
 * @version (eine Versionsnummer oder ein Datum)
 */
public class Benutzer
{
    
    public final int id;

	public Benutzer(int id) {
		this.id = id;
	}

	public String gibBenutzername() {
		QueryResult result = DatabaseInterface.executeQuery("SELECT `benutzername` FROM `benutzer` WHERE `id` = " + this.id);
		if(result.getRowCount() > 0) 
			return result.getData()[0][0];
		return null;
	}

	public String gibVorname() {
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `vorname` FROM `benutzer` WHERE `id` = " + this.id);
		if (result.getRowCount() > 0)
			return result.getData()[0][0];
		return null;
	}

	public String gibNachname() {
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `nachname` FROM `benutzer` WHERE `id` = " + this.id);
		if (result.getRowCount() > 0)
			return result.getData()[0][0];
		return null;
	}

	public String gibName() {
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `vorname`, `nachname` FROM `benutzer` WHERE `id` = " + this.id);
		if (result.getRowCount() > 0)
			return result.getData()[0][0] + " " + result.getData()[0][1];
		return null;
	}

	public boolean checkPasswort(String passwort) {
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `passwort` FROM `benutzer` WHERE `id` = " + this.id);
		return result.getRowCount() > 0 && passwort == result.getData()[0][0];
	}

	public Einkaufsliste gibListe(String titel) {
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `id` FROM `einkaufslisten` WHERE `benutzer_id` = " + this.id + " AND `titel` = " + titel);

		if(result.getRowCount() > 0)
			return new Einkaufsliste(Integer.parseInt(result.getData()[0][0]));

		return null;
	}

	public List<Einkaufsliste> gibEinkaufslisten() {
		
		QueryResult result = DatabaseInterface
				.executeQuery("SELECT `id` FROM `einkaufslisten` WHERE `benutzer_id` = " + this.id);
		
		ArrayList<Einkaufsliste> listen = new ArrayList<>();

		for(int i = 0; i < result.getRowCount(); i++)
			listen.add(new Einkaufsliste(Integer.parseInt(result.getData()[i][0])));
		
		return listen;
	}

}
