package co.com.mercadolibre.dto;

import java.io.Serializable;
import java.util.List;

public class DTOSatelitesIn implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<DTOSateliteGlobal> satellites;

	public DTOSatelitesIn() {
		super();
	}

	public DTOSatelitesIn(List<DTOSateliteGlobal> satellites) {
		super();
		this.satellites = satellites;
	}

	public List<DTOSateliteGlobal> getsatellites() {
		return satellites;
	}

	public void setsatellites(List<DTOSateliteGlobal> satellites) {
		this.satellites = satellites;
	}

}
