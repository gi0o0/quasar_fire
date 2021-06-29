package co.com.mercadolibre.dto;

import java.io.Serializable;

public class DTOPosicion implements Serializable {

	private static final long serialVersionUID = 1L;

	private double x;

	private double y;
	
	public DTOPosicion(double[] location) {
		this.x = location[0];
		this.y = location[1];
	}
	
	public DTOPosicion() {
	}

	public void setY(double y) {
		this.y = y;
	}

	public void setX(double x) {
		this.x = x;
	}

	public double getY() {
		return y;
	}

	public double getX() {
		return x;
	}

}
