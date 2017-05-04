

import org.junit.Assert;
import org.junit.Test;

import items.Megazine;

public class MagazineTest {

	@Test
	public void test() {
		Megazine megazine = new Megazine();
		Assert.assertTrue(megazine.getDataFromUser("name"));
	}

}
