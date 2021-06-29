package co.com.mercadolibre.mapper.impl;

import org.springframework.beans.factory.annotation.Autowired;

import co.com.mercadolibre.dto.DTOSatelite;
import co.com.mercadolibre.dto.DTOSateliteGlobal;
import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.exception.ModeloNotFoundException;
import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.util.Constantes;
import co.com.mercadolibre.util.UtilidadesService;

public class ComunicacionMapper implements IComunicacionMapper {

	private final UtilidadesService utilidadesService;

	@Autowired
	public ComunicacionMapper(UtilidadesService utilidadesService) {
		super();
		this.utilidadesService = utilidadesService;
	}

	@Override
	public Satelite getSatelitesIn(DTOSatelite in, String satelliteName) {
		Satelite out = new Satelite();
		if (null == in || null == in.getMessage())
			throw new ModeloNotFoundException(Constantes.ERROR_INSUFFICIENT_MESSAGES);
		out.setName(satelliteName);
		out.setDistance(in.getDistance());
		out.setMessage(utilidadesService.convertListToString(in.getMessage(), 1));
		return out;
	}

	@Override
	public Satelite getSatelitesIn(DTOSateliteGlobal in) {
		if (null == in)
			throw new ModeloNotFoundException(Constantes.ERROR_INSUFFICIENT_MESSAGES);
		return new Satelite(in.getName(), in.getDistance(), utilidadesService.convertListToString(in.getMessage(), 1));
	}

}
