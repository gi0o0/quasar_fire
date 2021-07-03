package co.com.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.dto.DTOSatelitesOut;
import co.com.mercadolibre.service.IComunicacionService;
import co.com.mercadolibre.util.Constantes;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(Constantes.PATH_COMUNICATION_CONTEXT)
public class ComunicacionController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ComunicacionController.class);

	private final IComunicacionService comunicacionesService;

	@Autowired
	public ComunicacionController(IComunicacionService comunicacionesService) {
		super();
		this.comunicacionesService = comunicacionesService;
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<DTOSatelitesOut> sourceContent(@RequestBody DTOSatelitesIn satelite) {	
		LOGGER.info("Inicio sourceContent en controller Request:"+satelite);
		return new ResponseEntity<DTOSatelitesOut>(comunicacionesService.retrySourceContentMessage(satelite),HttpStatus.CREATED);
	}

}
