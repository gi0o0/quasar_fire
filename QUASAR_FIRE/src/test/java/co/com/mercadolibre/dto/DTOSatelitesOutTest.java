package co.com.mercadolibre.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DTOSatelitesOutTest {

	@Test
	public void Should_Not_Equal_Null() {
		final DTOSatelitesOut satelite = new DTOSatelitesOut();
		final boolean result = satelite.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final DTOSatelitesOut satelite = new DTOSatelitesOut();
		satelite.setMessage("message");
		final int result1 = satelite.hashCode();
		final int result2 = satelite.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final DTOSatelitesOut satelite = new DTOSatelitesOut();

		satelite.setMessage("message");

		final DTOSatelitesOut satelite2 = new DTOSatelitesOut();

		satelite2.setMessage("message2");

		final int result1 = satelite.hashCode();
		final int result2 = satelite2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final DTOSatelitesOut satelite = new DTOSatelitesOut();
		final boolean result = satelite.equals(satelite);
		assertTrue(result);
	}
}