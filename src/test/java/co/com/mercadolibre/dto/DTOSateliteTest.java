package co.com.mercadolibre.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DTOSateliteTest {

	@Test
	public void Should_Not_Equal_Null() {
		final DTOSatelite satelite = new DTOSatelite();
		final boolean result = satelite.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final DTOSatelite satelite = new DTOSatelite();
		satelite.setDistance(0.0);
		final int result1 = satelite.hashCode();
		final int result2 = satelite.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final DTOSatelite satelite = new DTOSatelite();

		satelite.setDistance(0.0);

		final DTOSatelite satelite2 = new DTOSatelite();
		satelite2.setDistance(1.0);

		final int result1 = satelite.hashCode();
		final int result2 = satelite2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final DTOSatelite satelite = new DTOSatelite();
		final boolean result = satelite.equals(satelite);
		assertTrue(result);
	}
}