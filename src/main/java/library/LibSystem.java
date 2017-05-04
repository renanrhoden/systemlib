package library;

import java.io.IOException;

import db.LibraryDB;
import items.Book;
import items.Megazine;
import items.ScientificArticle;

public class LibSystem {

	public static void main(String[] args) {
		LibraryDB.createBookTableIfNotExists();
		/*Book book = new Book();
		
		for (String key : Messages.getMessages().keySet()) {
			book.requestData(Messages.getMessages().get(key), key);
		}
		
		*/
		
		try {
			String password = new jline.ConsoleReader().readLine(new Character('*'));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		LibraryDB.registerNewItem(Book.getExampleOfBook());
		
		LibraryDB.createMegazineTableIfNotExists();
		LibraryDB.registerNewItem(Megazine.getExpleOFMegazine());
		
		LibraryDB.createScientificArticleTableIfNotExists();
		LibraryDB.registerNewItem(ScientificArticle.getExampleOfArticle());
		
		LibraryDB.printTable();

	}
}
