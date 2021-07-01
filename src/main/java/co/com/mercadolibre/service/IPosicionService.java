package co.com.mercadolibre.service;

import java.util.List;

import co.com.mercadolibre.entities.Satelite;

public interface IPosicionService {

	double[][] getCoordinatesSatelites(List<Satelite> satelites);

	double[] getDistanceSatelites(List<Satelite> satelites);

	double[] getLocation(double[][] coordinatesSatelites, double[] distanceSatelites);
	
	String[] getCoordinateSatellite(String name);
}
