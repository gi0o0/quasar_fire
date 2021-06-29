package co.com.mercadolibre.mapper;

import co.com.mercadolibre.dto.DTOSatelite;
import co.com.mercadolibre.dto.DTOSateliteGlobal;
import co.com.mercadolibre.entities.Satelite;

public interface IComunicacionMapper {
	
	Satelite getSatelitesIn(DTOSatelite in,String satelliteName) ;
	
	Satelite getSatelitesIn(DTOSateliteGlobal in) ;
			
}
