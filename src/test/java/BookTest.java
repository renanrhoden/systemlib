
import org.junit.Test;

import items.Book;

import org.junit.Assert;
import org.junit.Before;

public class BookTest {
	Book book;
	@Before public void initialize(){
		 book =  new Book();
	}
	
	@Test public void testSaveDataFromUserWithBarCode() {
		Assert.assertTrue(book.saveDataFromUser("barcode", "15436547"));
	}
	
	@Test public void testSaveDataFromUserWithName() {
		Assert.assertTrue(book.saveDataFromUser("name", "Renan"));
	}
	
	@Test public void testSaveDataFromUserWithAuthor() {
		Assert.assertTrue(book.saveDataFromUser("author", "Rhoden"));
	}
	
	@Test public void testSaveDataFromUserWithISBN() {
		Assert.assertTrue(book.saveDataFromUser("ISBN", "1234567890123"));
	}
	
	@Test public void testSaveDataFromUserWithNumberOFPages() {
		Assert.assertTrue(book.saveDataFromUser("numberOfPages", "012"));
	}
	
	@Test public void testSaveDataFromUserWithEdition() {
		Assert.assertTrue(book.saveDataFromUser("edition", "8"));
	}
	
	@Test public void testSaveDataFromUserWithAvailable() {
		Assert.assertTrue(book.saveDataFromUser("available", "y"));
	}
	
	@Test public void testSaveDataFromUserWithSubject() {
		Assert.assertTrue(book.saveDataFromUser("subject", "Science"));
	}
	
}



