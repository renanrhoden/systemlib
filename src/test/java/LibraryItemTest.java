

import org.junit.Assert;
import org.junit.Test;

import items.Book;
import items.LibraryItem;

public class LibraryItemTest {
	
	@Test
	public void testSetAttributesBarcode() {
		LibraryItem item = new LibraryItem();
		Assert.assertTrue(item.setAttributes("barcode", "12345678"));
	}

	@Test
	public void testSetAttributesName() {
		LibraryItem item = new LibraryItem();
		Assert.assertTrue(item.setAttributes("name", "Renan Rhoden"));
	}
	
	@Test
	public void testSetAttributesNumberOfPages() {
		LibraryItem item = new LibraryItem();
		Assert.assertTrue(item.setAttributes("numberOfPages", "78"));
	}
	
	@Test
	public void testSetAttributesAvailable() {
		LibraryItem item = new LibraryItem();
		Assert.assertTrue(item.setAttributes("available", "y"));
	}
	
	@Test
	public void returnItem(){
		LibraryItem item = new LibraryItem();
		Assert.assertTrue(item.returnItem(Book.getExampleOfBook().getBarcode(), "book"));
	}
	
}
