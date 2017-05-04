import org.junit.Assert;
import org.junit.Test;

import items.ScientificArticle;

public class ScientificArticleTest {

	@Test
	public void test() {
		ScientificArticle sciArt = new ScientificArticle();
		Assert.assertTrue(sciArt.getDataFromUser("author"));
	}

}
