package co.com.mercadolibre.dto;

import java.io.Serializable;
import java.util.List;

public class DTOSateliteGlobal extends DTOSatelite implements Serializable {

	private static final long serialVersionUID = 1L;

	private String name;

	public DTOSateliteGlobal() {
		super();
	}

	public DTOSateliteGlobal(String name,List<String> message,double distance ) {
		super();
		this.name = name;
		this.message = message;
		this.distance= distance;
	}

	public DTOSateliteGlobal(List<String> message) {
		super();
		this.message = message;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

}
