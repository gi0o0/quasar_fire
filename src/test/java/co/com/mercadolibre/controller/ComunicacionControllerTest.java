package co.com.mercadolibre.controller;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.mercadolibre.dao.ISateliteDAO;
import co.com.mercadolibre.dto.DTOSatelite;
import co.com.mercadolibre.dto.DTOSateliteGlobal;
import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.mapper.impl.ComunicacionMapper;
import co.com.mercadolibre.service.IComunicacionService;
import co.com.mercadolibre.service.IMensajeService;
import co.com.mercadolibre.service.IPosicionService;
import co.com.mercadolibre.service.impl.ComunicacionService;
import co.com.mercadolibre.service.impl.MensajeService;
import co.com.mercadolibre.service.impl.PosicionService;
import co.com.mercadolibre.util.UtilidadesService;

@RunWith(SpringRunner.class)
@WebMvcTest(ComunicacionController.class)
public class ComunicacionControllerTest {

	private MockMvc mvcMock;

	@MockBean
	private UtilidadesService utilidadesService;

	@MockBean
	private IComunicacionService comunicacionServiceMockService;

	private IComunicacionService comunicacionService;

	private IPosicionService posicionService;

	private IMensajeService mensajeService;

	private ISateliteDAO dao;

	private IComunicacionMapper comunicacionMapper;

	@Before
	public void setUp() {

		dao = mock(ISateliteDAO.class);
		posicionService = new PosicionService(dao);
		comunicacionMapper = new ComunicacionMapper(utilidadesService);
		mensajeService = new MensajeService(utilidadesService);
		comunicacionService = new ComunicacionService(posicionService, mensajeService, dao, comunicacionMapper);
		mvcMock = MockMvcBuilders.standaloneSetup(new ComunicacionController(comunicacionService)).build();
	}

	@Test
	public void givenAValidDNAArrayThenShouldReturnStatus200() throws Exception {

		final ObjectMapper mapper = new ObjectMapper();
		DTOSatelitesIn in = new DTOSatelitesIn();
		List<DTOSateliteGlobal> satellites = new ArrayList<DTOSateliteGlobal>();
		List<String> message = new ArrayList<>();
		message.add("mama");
		message.add("donde");
		message.add("");
		message.add("");
		message.add("");
		satellites.add(new DTOSateliteGlobal("sato", message, 142.7));
		message = new ArrayList<>();
		message.add("");
		message.add("");
		message.add("esta");
		message.add("la");
		message.add("");
		satellites.add(new DTOSateliteGlobal("skywalker", message, 115.5));
		message = new ArrayList<>();
		message.add("");
		message.add("");
		message.add("");
		message.add("");
		message.add("comida");
		satellites.add(new DTOSateliteGlobal("kenobi", message, 100.0));
		in.setsatellites(satellites);

		List<Satelite> satelitesPositions = new ArrayList<>();

		Satelite satelite = new Satelite();
		satelite.setId(1L);
		satelite.setName("skywalker");
		satelite.setCoordinatex(500.0);
		satelite.setCoordinatey(100.0);
		satelite.setDistance(115.5);
		satelite.setMessage("mama,donde,,,");

		Satelite satelite2 = new Satelite();
		satelite2.setId(2L);
		satelite2.setName("sato");
		satelite2.setCoordinatex(500.0);
		satelite2.setCoordinatey(100.0);
		satelite2.setDistance(142.7);
		satelite2.setMessage(",,esta,la,");

		Satelite satelite3 = new Satelite();
		satelite3.setId(3L);
		satelite3.setName("kenobi");
		satelite3.setCoordinatex(-500.0);
		satelite3.setCoordinatey(-200.0);
		satelite3.setDistance(100.0);
		satelite3.setMessage(",,,,comida");
		
		
		satelitesPositions.add(satelite);
		satelitesPositions.add(satelite2);
		satelitesPositions.add(satelite3);

		List<Satelite> satelites = new ArrayList<>();
		satelites.add(satelite);
		when(dao.findOneByName(any())).thenReturn(satelites);
		when(dao.save(any(Satelite.class))).thenReturn(satelite);
		when(dao.findAll()).thenReturn(satelitesPositions);

		mvcMock.perform(
				post("/topsecret").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(in)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));;

	}

	@Test
	public void givenANoValidDataArrayThenShouldReturnStatus404() throws Exception {

		final ObjectMapper mapper = new ObjectMapper();
		DTOSatelitesIn in = new DTOSatelitesIn();
		List<DTOSateliteGlobal> satellites = new ArrayList<DTOSateliteGlobal>();
		List<String> message = new ArrayList<>();
		message.add("mama");
		message.add("donde");
		message.add("");
		message.add("");
		message.add("");
		satellites.add(new DTOSateliteGlobal("sato", message, 142.7));
		message = new ArrayList<>();
		message.add("");
		message.add("");
		message.add("esta");
		message.add("la");
		message.add("");
		satellites.add(new DTOSateliteGlobal("skywalker", message, 115.5));
		message = new ArrayList<>();
		message.add("");
		message.add("");
		message.add("");
		message.add("");
		message.add("comida");
		satellites.add(new DTOSateliteGlobal("kenobi", message, 100.0));
		in.setsatellites(satellites);

		mvcMock.perform(
				post("/topsecret").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(in)))
				.andExpect(status().isNotFound());

	}
	
	
	@Test
	public void givenANoValidMessageSplitThenShouldReturnStatus404() throws Exception {

		final ObjectMapper mapper = new ObjectMapper();

		List<String> message = new ArrayList<>();
		message.add("mama");
		message.add("donde");
		message.add("");
		message.add("");
		message.add("");
		
		DTOSatelite satelite =new DTOSatelite();
		satelite.setDistance(100.0);
		satelite.setMessage(message);
		
		mvcMock.perform(
				post("/topsecret_split/otro").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(satelite)))
				.andExpect(status().isNotFound());

	}
	
	
	@Test
	public void givenAValidMessageSplitThenShouldReturnStatus201() throws Exception {

		mvcMock.perform(
				get("/topsecret_split").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isNotFound());

	}

}