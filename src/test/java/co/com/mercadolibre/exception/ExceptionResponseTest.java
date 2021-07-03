package co.com.mercadolibre.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.Date;

import org.junit.Test;

public class ExceptionResponseTest {

	@Test
	public void Should_Not_Equal_Null() {
		final ExceptionResponse exception = new ExceptionResponse(new Date(), "", "");
		final boolean result = exception.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final ExceptionResponse exception = new ExceptionResponse(new Date(), "", "");
		exception.setDetalles("ERROR1");
		final int result1 = exception.hashCode();
		final int result2 = exception.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final ExceptionResponse exception = new ExceptionResponse(new Date(), "", "");

		exception.setDetalles("ERROR1");

		final ExceptionResponse exception2 = new ExceptionResponse(new Date(), "", "");
		exception2.setDetalles("ERROR2");

		final int result1 = exception.hashCode();
		final int result2 = exception2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final ExceptionResponse exception = new ExceptionResponse(new Date(), "", "");
		final boolean result = exception.equals(exception);
		assertTrue(result);
	}

	@Test
	public void Should_Equal_ItselAllObject() {

		Date now = new Date();
		final ExceptionResponse exception = new ExceptionResponse(now, "", "");
		String detalle = "Detalle";
		String mensaje = "Mensaje";

		exception.setTimestamp(new Date());
		exception.setDetalles(detalle);
		exception.setMensaje(mensaje);

		final boolean result = exception.equals(exception);
		assertTrue(result);

		final boolean result2 = detalle.equals(exception.getDetalles());
		assertTrue(result2);

		final boolean result3 = mensaje.equals(exception.getMensaje());
		assertTrue(result3);

		final boolean result4 = now.toString().equals(exception.getTimestamp().toString());
		assertTrue(result4);
	}

}
