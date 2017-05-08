package dbTest;

import org.junit.Assert;
import org.junit.Test;

import db.LibraryDB;
import items.Book;

public class LibraryDBTest {

	@Test
	public void getBookTest() {
		Assert.assertEquals(LibraryDB.getBook(Book.getExampleOfBook().getBarcode()).toString(), Book.getExampleOfBook().toString());
	}

}
