
import java.sql.*;
import java.util.*;

import javax.swing.*;
import java.awt.*;

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

		JFrame frame = new JFrame();
		frame.setSize(500, 800);
		frame.setName("Einkaufsliste");

		Container pane = frame.getContentPane();
		// pane.setLayout(new GridLayout(0, 1));
		pane.setLayout(new FlowLayout(FlowLayout.CENTER, 999999999, 10)); // TODO: ugly

		Benutzer benutzer = new Benutzer(1);
		Einkaufsliste liste = benutzer.gibEinkaufslisten().get(0);

		if(liste != null) {
			JTextArea titel = new JTextArea(liste.gibTitel());
			titel.setSize(500, 50);
			pane.add(titel);

			for(Map.Entry<Produkt, Integer> produkt : liste.gibProdukte().entrySet()) {
				pane.add(new JLabel(produkt.getKey().gibBezeichnung() + ": " + produkt.getValue()));
			}

		}

		frame.setVisible(true);

        con.close();
    }

}
