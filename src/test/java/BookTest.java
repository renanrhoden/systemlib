
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
		Assert.assertTrue(book.isEmpty("barcode", "15436547"));
	}
	
	@Test public void testSaveDataFromUserWithName() {
		Assert.assertTrue(book.isEmpty("name", "Renan"));
	}
	
	@Test public void testSaveDataFromUserWithAuthor() {
		Assert.assertTrue(book.isEmpty("author", "Rhoden"));
	}
	
	@Test public void testSaveDataFromUserWithISBN() {
		Assert.assertTrue(book.isEmpty("ISBN", "1234567890123"));
	}
	
	@Test public void testSaveDataFromUserWithNumberOFPages() {
		Assert.assertTrue(book.isEmpty("numberOfPages", "012"));
	}
	
	@Test public void testSaveDataFromUserWithEdition() {
		Assert.assertTrue(book.isEmpty("edition", "8"));
	}
	
	@Test public void testSaveDataFromUserWithAvailable() {
		Assert.assertTrue(book.isEmpty("available", "y"));
	}
	
	@Test public void testSaveDataFromUserWithSubject() {
		Assert.assertTrue(book.isEmpty("subject", "Science"));
	}
	
}



