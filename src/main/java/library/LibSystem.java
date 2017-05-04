package library;
import db.LibraryDB;

public class LibSystem {

	public static void main(String[] args) {
		LibraryDB.createBookTableIfNotExists();
		/*Book book = new Book();
		
		for (String key : Messages.getMessages().keySet()) {
			book.requestData(Messages.getMessages().get(key), key);
		}
		
		*/
		LibraryDB.registerNewItem(Book.getExampleOfBook());
		
		LibraryDB.createMegazineTableIfNotExists();
		LibraryDB.registerNewItem(Megazine.getExpleOFMegazine());
		
		LibraryDB.createScientificArticleTableIfNotExists();
		LibraryDB.registerNewItem(ScientificArticle.getExampleOfArticle());
		
		LibraryDB.printTable();

	}
}
