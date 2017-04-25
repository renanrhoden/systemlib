

import org.junit.Assert;
import org.junit.Test;

import library.Megazine;

public class MagazineTest {

	@Test
	public void test() {
		Megazine megazine = new Megazine();
		Assert.assertTrue(megazine.getDataFromUser("name"));
	}

}
