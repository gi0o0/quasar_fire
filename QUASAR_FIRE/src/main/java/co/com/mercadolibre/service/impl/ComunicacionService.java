package co.com.mercadolibre.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mercadolibre.dao.ISateliteDAO;
import co.com.mercadolibre.dto.DTOPosicion;
import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.dto.DTOSatelitesOut;
import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.exception.ModeloNotFoundException;
import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.service.IComunicacionService;
import co.com.mercadolibre.service.IMensajeService;
import co.com.mercadolibre.service.IPosicionService;
import co.com.mercadolibre.util.Constantes;

@Service
public class ComunicacionService implements IComunicacionService {

	private final IPosicionService posicionService;

	private final IMensajeService mensajeService;

	private final ISateliteDAO dao;

	private final IComunicacionMapper comunicacionMapper;

	@Autowired
	public ComunicacionService(IPosicionService posicionService, IMensajeService mensajeService, ISateliteDAO dao,
			IComunicacionMapper comunicacionMapper) {
		super();
		this.posicionService = posicionService;
		this.mensajeService = mensajeService;
		this.dao = dao;
		this.comunicacionMapper = comunicacionMapper;
	}

	@Override
	public DTOSatelitesOut retrySourceContentMessage(DTOSatelitesIn in) {
		in.getsatellites().stream().forEach(item -> registrar(comunicacionMapper.getSatelitesIn(item)));
		return retrySourceContent();
	}

	@Override
	public DTOSatelitesOut retrySourceContent() {
		List<Satelite> satelitesPositions = (List<Satelite>) dao.findAll();
		DTOSatelitesOut out = new DTOSatelitesOut();
		out.setMessage(mensajeService.getMessage(satelitesPositions));
		out.setPosition(
				new DTOPosicion(posicionService.getLocation(posicionService.getCoordinatesSatelites(satelitesPositions),
						posicionService.getDistanceSatelites(satelitesPositions))));
		return out;
	}

	@Override
	public Satelite registrar(Satelite t) {
		List<Satelite> satelite = dao.findOneByName(t.getName().toLowerCase());
		if (satelite.size() == 0)
			throw new ModeloNotFoundException(Constantes.ERROR_UNKNOWN_SATELLITE);
		t.setCoordinatex(satelite.get(0).getCoordinatex());
		t.setCoordinatey(satelite.get(0).getCoordinatey());
		t.setId(satelite.get(0).getId());
		return dao.save(t);
	}

}
