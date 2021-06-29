package co.com.mercadolibre.dto;

import java.io.Serializable;

public class DTOSatelitesOut implements Serializable {

	private static final long serialVersionUID = 1L;

	private DTOPosicion position;

	private String message;

	public DTOSatelitesOut() {
		super();
	}

	public DTOPosicion getPosition() {
		return position;
	}

	public void setPosition(DTOPosicion position) {
		this.position = position;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
