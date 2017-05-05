package library;

import db.LibraryDB;
import items.Megazine;
import items.ScientificArticle;
import ui.LibUserInterface;

public class LibSystem {

	public static void main(String[] args) {
		

		LibUserInterface ui = new LibUserInterface();
		
		LibraryDB.registerNewItem(ui.requestBookData());
		LibraryDB.registerNewItem(Megazine.getExpleOFMegazine());
		LibraryDB.registerNewItem(ScientificArticle.getExampleOfArticle());
		
		LibraryDB.printTable();

	}
}
