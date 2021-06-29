package co.com.mercadolibre.dto;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class DTOSatelitesInTest {

	@Test
	public void Should_Not_Equal_Null() {
		final DTOSatelitesIn satelite = new DTOSatelitesIn();
		final boolean result = satelite.equals(null);
		assertFalse(result);
	}

	@Test
	public void Should_Generate_Same_Hash_Code_Every_Time() {
		final DTOSatelitesIn satelite = new DTOSatelitesIn();

		List<DTOSateliteGlobal> satellites = new ArrayList<DTOSateliteGlobal>();
		List<String> message = new ArrayList<>();
		message.add("Este");
		satellites.add(new DTOSateliteGlobal(message));
		satelite.setsatellites(satellites);

		final int result1 = satelite.hashCode();
		final int result2 = satelite.hashCode();
		assertEquals(result1, result2);
	}

	@Test
	public void Should_Generate_Different_Hash_Code_For_Different_Objects() {
		final DTOSatelitesIn satelite = new DTOSatelitesIn();

		List<DTOSateliteGlobal> satellites = new ArrayList<DTOSateliteGlobal>();
		List<String> message = new ArrayList<>();
		message.add("Este");
		satellites.add(new DTOSateliteGlobal(message));
		satelite.setsatellites(satellites);

		final DTOSatelitesIn satelite2 = new DTOSatelitesIn();
		
		List<DTOSateliteGlobal> satellites2 = new ArrayList<DTOSateliteGlobal>();
		List<String> message2 = new ArrayList<>();
		message.add("Estee");
		satellites.add(new DTOSateliteGlobal(message2));
		satelite2.setsatellites(satellites2);

		final int result1 = satelite.hashCode();
		final int result2 = satelite2.hashCode();

		assertNotEquals(result1, result2);
	}

	@Test
	public void Should_Equal_Itself() {
		final DTOSatelitesIn satelite = new DTOSatelitesIn();
		final boolean result = satelite.equals(satelite);
		assertTrue(result);
	}
}