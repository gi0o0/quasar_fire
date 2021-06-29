package co.com.mercadolibre.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "SATELITE")
public class Satelite {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;

	@Column(name = "name", nullable = false, length = 25)
	private String name;

	@Column(name = "distance", nullable = false, length = 70)
	private double distance;

	@Column(name = "message", nullable = false, length = 255)
	private String message;

	@Column(name = "coordinatex", nullable = false, length = 70)
	private double coordinatex;

	@Column(name = "coordinatey", nullable = false, length = 70)
	private double coordinatey;

	public Satelite() {
		super();
	}

	public Satelite(String name, double distance, String message) {
		super();
		this.name = name;
		this.distance = distance;
		this.message = message;
	}
	
	public Satelite(String name, String message) {
		super();
		this.name = name;
		this.message = message;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public double getCoordinatex() {
		return coordinatex;
	}

	public void setCoordinatex(double coordinatex) {
		this.coordinatex = coordinatex;
	}

	public double getCoordinatey() {
		return coordinatey;
	}

	public void setCoordinatey(double coordinatey) {
		this.coordinatey = coordinatey;
	}

}
