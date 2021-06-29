package co.com.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.dto.DTOSatelitesOut;
import co.com.mercadolibre.service.IComunicacionService;

@RestController
@RequestMapping("${communication.context.path}")
public class ComunicacionController {

	private final IComunicacionService comunicacionesService;

	@Autowired
	public ComunicacionController(IComunicacionService comunicacionesService) {
		super();
		this.comunicacionesService = comunicacionesService;
	}

	@PostMapping(produces = "application/json", consumes = "application/json")
	public DTOSatelitesOut sourceContent(@RequestBody DTOSatelitesIn in) {				
		return comunicacionesService.retrySourceContentMessage(in);
	}

}
