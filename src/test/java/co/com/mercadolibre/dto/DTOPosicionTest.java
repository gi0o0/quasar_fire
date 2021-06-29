package co.com.mercadolibre.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class DTOPosicionTest {

	@Test
	public void Should_Not_Equal_Null() {
		final DTOPosicion posicion = new DTOPosicion();
		final boolean result = posicion.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final DTOPosicion posicion = new DTOPosicion();
		posicion.setX(0.0);
		final int result1 = posicion.hashCode();
		final int result2 = posicion.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final DTOPosicion posicion = new DTOPosicion();

		posicion.setX(0.0);

		final DTOPosicion posicion2 = new DTOPosicion();
		posicion2.setX(1.0);

		final int result1 = posicion.hashCode();
		final int result2 = posicion2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final DTOPosicion posicion = new DTOPosicion();
		final boolean result = posicion.equals(posicion);
		assertTrue(result);
	}
}