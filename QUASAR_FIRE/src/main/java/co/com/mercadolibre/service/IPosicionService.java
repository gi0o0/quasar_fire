package co.com.mercadolibre.service;

import java.util.List;

import co.com.mercadolibre.entities.Satelite;

public interface IPosicionService {

	double[][] getCoordinatesSatelites(List<Satelite> in);

	double[] getDistanceSatelites(List<Satelite> in);

	double[] getLocation(double[][] coordinatesSatelites, double[] distanceSatelites);
}
