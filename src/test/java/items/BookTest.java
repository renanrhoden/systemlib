package items;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class BookTest {
	Book book;
	@Before public void initialize(){
		 book =  new Book();
	}

	@Test
	public void testSetAttributes() {
		Assert.assertTrue(book.setAttributes("barcode", "15436547"));
		Assert.assertTrue(book.setAttributes("name", "Renan"));
		Assert.assertTrue(book.setAttributes("author", "Rhoden"));
		Assert.assertTrue(book.setAttributes("ISBN", "1234567890123"));
		Assert.assertTrue(book.setAttributes("numberOfPages", "012"));
		Assert.assertTrue(book.setAttributes("edition", "8"));
		Assert.assertTrue(book.setAttributes("available", "y"));
		Assert.assertTrue(book.setAttributes("subject", "Science"));
		Assert.assertFalse(book.setAttributes("barcode", "letters"));
		Assert.assertFalse(book.setAttributes("ISBN", "letters"));
		Assert.assertFalse(book.setAttributes("numberOfPages", "letters"));
		Assert.assertFalse(book.setAttributes("edition", "letters"));
		Assert.assertFalse(book.setAttributes("available", "yes"));
	}


	@Test
	public void testIsNotEmpty() {
		Assert.assertTrue(book.isNotEmpty("subject", "Science"));
	}

}
