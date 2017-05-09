package library;

import db.LibraryDB;
import items.Book;
import items.Megazine;
import items.ScientificArticle;
import ui.UI;

public class LibSystem {

	public static void main(String[] args) {
		
		
		UI ui = new UI();
		ui.uiLoop();
		/*
		UI.showOptions();
		LibraryDB.deleteTable("book");
		
		LibraryDB.registerNewItem(Book.getExampleOfBook());
		LibraryDB.registerNewItem(Megazine.getExpleOFMegazine());
		LibraryDB.registerNewItem(ScientificArticle.getExampleOfArticle());
		LibraryDB.printTable();
		//LibraryDB.updateItem(Book.getExampleOfBook(), "name", "Renan Rhoden");
		LibraryDB.printTable();
		
		LibraryDB.listBorrowedItems();
		/*
		try {
			LibraryDB.showColumnsNames("Scientific_Article");
		} catch (SQLException e) {
			System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		}
		*/

	}
}
