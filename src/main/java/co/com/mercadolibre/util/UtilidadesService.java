package co.com.mercadolibre.util;

import java.util.Arrays;
import java.util.List;

public class UtilidadesService {

	public String convertListToString(List<String> cadenas, int type) {

		String out = "";

		switch (type) {
		case 0:
			out = Arrays.toString(cadenas.toArray()).replace("[", "").replace("]", "").replace(",", "");
			break;
		case 1:
			out = Arrays.toString(cadenas.toArray()).replace("[", "").replace("]", "").replace(" ", "");
			break;
		}

		return out;

	}

}
