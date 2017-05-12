package items;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class LibraryItemTest {
	LibraryItem item;
	
	@Before
	public void firstOfAll(){
		item = new LibraryItem();
	}

	@Test
	public void testReturnItem() {
		Assert.assertTrue(item.returnItem("book", "12345678"));
	}

	@Test
	public void testSearch() {
		Assert.assertEquals(Book.getExampleOfBook().toString(), item.search("book", Book.getExampleOfBook().getBarcode()).toString());
	}

	@Test
	public void testCheckOut() {
		Assert.assertTrue(item.checkOut("book", Book.getExampleOfBook().getBarcode()));
	}

	@Test
	public void testSetAttributes() {
		Assert.assertTrue(item.setAttributes("barcode", "13246578"));
	}

}
