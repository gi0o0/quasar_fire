package co.com.mercadolibre.service;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.exception.ModeloNotFoundException;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ComunicacionServiceTest {

	@Autowired
	private IMensajeService mensajeService;

	@Test
	public void whenMessageIsValidShoulddReturnAValidMessage() {
		List<Satelite> satellites = new ArrayList<>();
		satellites.add(new Satelite("kenobi", "mama,,,,comida"));
		satellites.add(new Satelite("skywalker", ",donde,,,"));
		satellites.add(new Satelite("sato", ",,esta,la,"));
		assertEquals("mama donde esta la comida", mensajeService.getMessage(satellites));

	}

	@Test(expected = ModeloNotFoundException.class)
	public void whenMessageIsNoValid() {
		List<Satelite> satellites = new ArrayList<>();
		satellites.add(new Satelite("kenobi", "mama,,,,"));
		satellites.add(new Satelite("skywalker", ",donde,,,"));
		satellites.add(new Satelite("sato", ",,esta,la,"));

		assertNotEquals("mama donde esta la comida", mensajeService.getMessage(satellites));
	}

	@Test(expected = ModeloNotFoundException.class)
	public void wheNamesateliteIsNoValid() {
		List<Satelite> satellites = new ArrayList<>();
		satellites.add(new Satelite("Gio", "mama,,,,"));
		satellites.add(new Satelite("skywalker", ",donde,,,"));
		satellites.add(new Satelite("sato", ",,esta,la,"));
		assertNotEquals("mama donde esta la comida", mensajeService.getMessage(satellites));

	}
	

	@Test(expected = ModeloNotFoundException.class)
	public void wheLenghtIsNoValid() {
		List<Satelite> satellites = new ArrayList<>();
		satellites.add(new Satelite("Gio", "mama,"));
		satellites.add(new Satelite("skywalker", ",donde,,,"));
		satellites.add(new Satelite("sato", ",,esta,la,"));
		assertNotEquals("mama donde esta la comida", mensajeService.getMessage(satellites));

	}

}
