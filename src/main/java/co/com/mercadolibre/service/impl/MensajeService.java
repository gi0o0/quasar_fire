package co.com.mercadolibre.service.impl;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.exception.ModeloNotFoundException;
import co.com.mercadolibre.service.IMensajeService;
import co.com.mercadolibre.util.Constantes;
import co.com.mercadolibre.util.UtilidadesService;

@Service
public class MensajeService implements IMensajeService {

	private final UtilidadesService utilidadesService;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(MensajeService.class);

	@Autowired
	public MensajeService(UtilidadesService utilidadesService) {
		super();
		this.utilidadesService = utilidadesService;
	}

	@Override
	public String getMessage(List<Satelite> satelites) {
		
		LOGGER.info("Inicio getMessage en service Request:"+satelites);

		List<String> baseList = new ArrayList<String>();
		for (Satelite obj : satelites) {
			if (null == obj.getMessage())
				throw new ModeloNotFoundException(Constantes.ERROR_INSUFFICIENT_MESSAGES_DETERMINED);
			baseList = Stream.concat(baseList.stream(), Arrays.stream(obj.getMessage().split("\\,", -1)))
					.filter(x -> !x.equals("")).distinct().collect(Collectors.toList());

		}
		for (Satelite obj : satelites) {
			String message[] = obj.getMessage().split("\\,", -1);
			if (message.length != baseList.size())
				throw new ModeloNotFoundException(Constantes.ERROR_INSUFFICIENT_MESSAGES_DETERMINED);
			for (int i = 0; i < message.length; i++) {
				if (!"".equals(message[i]))
					baseList.set(i, message[i]);
			}
		}
		return utilidadesService.convertListToString(baseList, 0);

	}
}
