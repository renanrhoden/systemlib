
import org.junit.Test;

import library.Book;
import org.junit.Assert;

public class BookTest {
	@Test public void testGetDataFromUserWithBarCode() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("barcode"));
	}
	
	@Test public void testGetDataFromUserWithName() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("name"));
	}
	
	@Test public void testGetDataFromUserWithAuthor() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("author"));
	}
	
	@Test public void testGetDataFromUserWithISBN() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("ISBN"));
	}
	
	@Test public void testGetDataFromUserWithNumberOFPages() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("numberOfPages"));
	}
	
	@Test public void testGetDataFromUserWithEdition() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("edition"));
	}
	
	@Test public void testGetDataFromUserWithAvailable() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("available"));
	}
	
	@Test public void testGetDataFromUserWithSubject() {
		Book book =  new Book();
		Assert.assertTrue(book.saveDataFromUser("subject"));
	}
	
}
