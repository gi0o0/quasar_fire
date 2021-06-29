package co.com.mercadolibre.dto;

import java.io.Serializable;
import java.util.List;

public class DTOSatelite implements Serializable {

	private static final long serialVersionUID = 1L;

	public double distance;

	public List<String> message;

	public DTOSatelite() {
		super();
	}

	public DTOSatelite(List<String> message) {
		super();
		this.message = message;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public void setMessage(List<String> message) {
		this.message = message;
	}

	public double getDistance() {
		return distance;
	}

	public List<String> getMessage() {
		return message;
	}

}
