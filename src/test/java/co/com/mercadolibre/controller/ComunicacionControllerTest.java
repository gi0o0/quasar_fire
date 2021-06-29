package co.com.mercadolibre.controller;

import static org.mockito.Mockito.mock;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;

import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.mercadolibre.dao.ISateliteDAO;
import co.com.mercadolibre.dto.DTOSateliteGlobal;
import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.mapper.impl.ComunicacionMapper;
import co.com.mercadolibre.service.IComunicacionService;
import co.com.mercadolibre.service.IMensajeService;
import co.com.mercadolibre.service.IPosicionService;
import co.com.mercadolibre.service.impl.ComunicacionService;
import co.com.mercadolibre.service.impl.MensajeService;
import co.com.mercadolibre.service.impl.PosicionService;
import co.com.mercadolibre.util.UtilidadesService;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@WebMvcTest(ComunicacionController.class)
public class ComunicacionControllerTest {
	
	
	private MockMvc mvcMock;
	
	@Autowired  
	private MockMvc mvc;

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
		
//		mvc = MockMvcBuilders.standaloneSetup(new ComunicacionController(comunicacionService)).build();
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
		
		for(DTOSateliteGlobal ou:in.getsatellites()) {
			System.out.println("*************************************"+ou.getName());
		}
		

		mvcMock.perform(
				post("/topsecret").contentType(MediaType.APPLICATION_JSON).content(mapper.writeValueAsString(in)))
				.andExpect(status().isOk()).andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));


	}
}