package co.com.mercadolibre.exception;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ResponseExceptionHandlerTest {

	@Test
	public void Should_Not_Equal_Null() {
		final ResponseExceptionHandler exception = new ResponseExceptionHandler();
		final boolean result = exception.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final ResponseExceptionHandler exception = new ResponseExceptionHandler();

		final int result1 = exception.hashCode();
		final int result2 = exception.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final ResponseExceptionHandler exception = new ResponseExceptionHandler();

		final ResponseExceptionHandler exception2 = new ResponseExceptionHandler();

		final int result1 = exception.hashCode();
		final int result2 = exception2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final ResponseExceptionHandler exception = new ResponseExceptionHandler();
		final boolean result = exception.equals(exception);
		assertTrue(result);
	}

}
