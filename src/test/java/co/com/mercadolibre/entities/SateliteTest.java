package co.com.mercadolibre.entities;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class SateliteTest {

	@Test
	public void Should_Not_Equal_Null() {
		final Satelite satelite = new Satelite();
		final boolean result = satelite.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final Satelite satelite = new Satelite();
		satelite.setCoordinatex(0.12);
		satelite.setCoordinatey(0.15);
		final int result1 = satelite.hashCode();
		final int result2 = satelite.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final Satelite satelite = new Satelite();

		satelite.setCoordinatex(0.12);
		satelite.setCoordinatey(0.15);

		final Satelite satelite2 = new Satelite();
		satelite.setCoordinatex(1.12);
		satelite.setCoordinatey(1.15);

		final int result1 = satelite.hashCode();
		final int result2 = satelite2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final Satelite satelite = new Satelite();
		final boolean result = satelite.equals(satelite);
		assertTrue(result);
	}

}
