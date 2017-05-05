package library;

import java.sql.SQLException;

import db.LibraryDB;
import items.Megazine;
import items.ScientificArticle;
import ui.UI;

public class LibSystem {

	public static void main(String[] args) {
		

		//UI ui = new UI();
		//UI.showOptions();
		
		//LibraryDB.registerNewItem(ui.requestBookData());
		LibraryDB.registerNewItem(Megazine.getExpleOFMegazine());
		LibraryDB.registerNewItem(ScientificArticle.getExampleOfArticle());
	
		LibraryDB.printTable();
		try {
			LibraryDB.showColumnsNames("Scientific_Article");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}

	}
}
