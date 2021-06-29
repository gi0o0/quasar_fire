package co.com.mercadolibre.mapper;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.mockito.Mockito;

import co.com.mercadolibre.dto.DTOSatelite;
import co.com.mercadolibre.dto.DTOSateliteGlobal;
import co.com.mercadolibre.exception.ModeloNotFoundException;
import co.com.mercadolibre.mapper.impl.ComunicacionMapper;
import co.com.mercadolibre.util.UtilidadesService;

public class ComunicacionMapperTest {

	@Test(expected = ModeloNotFoundException.class)
	public void whenEntityIsNullThenShouldReturnExceptionOneSatelite() {

		ComunicacionMapper comunicacionMapper = Mockito.mock(ComunicacionMapper.class);

		Mockito.when(comunicacionMapper.getSatelitesIn(Mockito.any())).thenCallRealMethod();

		comunicacionMapper.getSatelitesIn(null);
	}

	@Test(expected = ModeloNotFoundException.class)
	public void whenEntityIsNullThenShouldReturnExceptionAnySatelite() {

		ComunicacionMapper comunicacionMapper = Mockito.mock(ComunicacionMapper.class);

		Mockito.when(comunicacionMapper.getSatelitesIn(Mockito.any(), Mockito.any())).thenCallRealMethod();

		comunicacionMapper.getSatelitesIn(null, null);
	}

	@Test(expected = ModeloNotFoundException.class)
	public void whenEntityMessageIsNotNullThenShouldReturnException() {

		ComunicacionMapper comunicacionMapper = Mockito.mock(ComunicacionMapper.class);

		Mockito.when(comunicacionMapper.getSatelitesIn(Mockito.any(), Mockito.any())).thenCallRealMethod();

		comunicacionMapper.getSatelitesIn(null, "topsecret");
	}

	@Test
	public void whenEntitySateliteAndMessageIsNotNullThenShouldReturnOk() {

		UtilidadesService utilidadesService = Mockito.mock(UtilidadesService.class);

		ComunicacionMapper comunicacionMapper = new ComunicacionMapper(utilidadesService);

		DTOSatelite in = new DTOSatelite();

		in.setDistance(10.0);
		List<String> message = new ArrayList<>();
		message.add("Este");
		message.add("es");
		message.add("");
		message.add("");
		message.add("");
		in.setMessage(message);

		comunicacionMapper.getSatelitesIn(in, "topsecret");
	}

	@Test
	public void whenEntitySateliteIsNotNullThenShouldReturnOk() {

		UtilidadesService utilidadesService = Mockito.mock(UtilidadesService.class);

		ComunicacionMapper comunicacionMapper = new ComunicacionMapper(utilidadesService);

		DTOSateliteGlobal out = new DTOSateliteGlobal();

		List<String> message = new ArrayList<>();
		message.add("Este");
		message.add("es");
		message.add("");
		message.add("");
		message.add("");

		out.setName("topsecret");
		out.setMessage(message);
		out.setDistance(10.0);

		comunicacionMapper.getSatelitesIn(out);
	}

}
