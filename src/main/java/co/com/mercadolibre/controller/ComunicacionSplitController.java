package co.com.mercadolibre.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import co.com.mercadolibre.dto.DTOSatelite;
import co.com.mercadolibre.dto.DTOSatelitesOut;
import co.com.mercadolibre.mapper.IComunicacionMapper;
import co.com.mercadolibre.service.IComunicacionService;

@RestController
@RequestMapping("${communication_split.context.path}")
public class ComunicacionSplitController {

	private final IComunicacionService comunicacionesService;

	private final IComunicacionMapper comunicacionesMapper;

	@Autowired
	public ComunicacionSplitController(IComunicacionService comunicacionesService,
			IComunicacionMapper comunicacionesMapper) {
		super();
		this.comunicacionesService = comunicacionesService;
		this.comunicacionesMapper = comunicacionesMapper;
	}

	@PostMapping(value = "/{satellite_name}", produces = "application/json", consumes = "application/json")
	public ResponseEntity<Object> registrar(@PathVariable("satellite_name") String satelliteName,
			@RequestBody DTOSatelite in) {
		comunicacionesService.registrar(comunicacionesMapper.getSatelitesIn(in, satelliteName));
		return new ResponseEntity<>(HttpStatus.CREATED);

	}

	@GetMapping(produces = "application/json", consumes = "application/json")
	public DTOSatelitesOut sourceContent() {
		return comunicacionesService.retrySourceContent();
	}

}
