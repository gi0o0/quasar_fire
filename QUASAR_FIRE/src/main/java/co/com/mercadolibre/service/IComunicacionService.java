package co.com.mercadolibre.service;

import co.com.mercadolibre.dto.DTOSatelitesIn;
import co.com.mercadolibre.dto.DTOSatelitesOut;
import co.com.mercadolibre.entities.Satelite;

public interface IComunicacionService {

	DTOSatelitesOut retrySourceContentMessage(DTOSatelitesIn in);

	DTOSatelitesOut retrySourceContent();

	Satelite registrar(Satelite in);

}
