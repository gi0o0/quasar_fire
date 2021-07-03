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

@RestController
@RequestMapping(Constantes.PATH_COMUNICATION_CONTEXT)
public class ComunicacionController {

	private final IComunicacionService comunicacionesService;

	@Autowired
	public ComunicacionController(IComunicacionService comunicacionesService) {
		super();
		this.comunicacionesService = comunicacionesService;
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public ResponseEntity<DTOSatelitesOut> sourceContent(@RequestBody DTOSatelitesIn satelite) {	
		return new ResponseEntity<DTOSatelitesOut>(comunicacionesService.retrySourceContentMessage(satelite),HttpStatus.CREATED);
	}

}
