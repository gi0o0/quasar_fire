package co.com.mercadolibre.service.impl;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.math3.fitting.leastsquares.LeastSquaresOptimizer.Optimum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.math3.fitting.leastsquares.LevenbergMarquardtOptimizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lemmingapex.trilateration.NonLinearLeastSquaresSolver;
import com.lemmingapex.trilateration.TrilaterationFunction;

import co.com.mercadolibre.dao.ISateliteDAO;
import co.com.mercadolibre.entities.Satelite;
import co.com.mercadolibre.exception.ModeloNotFoundException;
import co.com.mercadolibre.service.IPosicionService;
import co.com.mercadolibre.util.Constantes;

@Service
public class PosicionService implements IPosicionService {

	private final ISateliteDAO dao;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(PosicionService.class);

	@Autowired
	public PosicionService(ISateliteDAO dao) {
		super();
		this.dao = dao;
	}

	@Override
	public double[] getLocation(double[][] coordinatesSatelites, double[] distanceSatelites) {
		
		LOGGER.info("Inicio getMessage en service Request:"+distanceSatelites);
		
		NonLinearLeastSquaresSolver solver = new NonLinearLeastSquaresSolver(
				new TrilaterationFunction(coordinatesSatelites, distanceSatelites), new LevenbergMarquardtOptimizer());
		Optimum optimum = solver.solve();
		return optimum.getPoint().toArray();
	}

	@Override
	public double[][] getCoordinatesSatelites(List<Satelite> satelites) {

		double[][] coordinatesSatellites = new double[satelites.size()][];
		for (int i = 0; i < satelites.size(); i++) {
			String[] coordinatesSatellite = getCoordinateSatellite(satelites.get(i).getName().toLowerCase());
			if (null == coordinatesSatellite)
				throw new ModeloNotFoundException(Constantes.ERROR_INSUFFICIENT_COORDINATES);
			coordinatesSatellites[i] = Arrays.stream(coordinatesSatellite).map(Double::valueOf)
					.mapToDouble(Double::doubleValue).toArray();
		}
		return coordinatesSatellites;
	}

	@Override
	public double[] getDistanceSatelites(List<Satelite> satelites) {
		int size = satelites.size();
		double[] distances = new double[size];
		for (int i = 0; i < size; i++)
			distances[i] = satelites.get(i).getDistance();
		return distances;
	}

	@Override
	public String[] getCoordinateSatellite(String name) {
		String out[] = new String[2];
		final Satelite satelite = dao.findOneByName(name).get(0);
		out[0] = String.valueOf(satelite.getCoordinatex());
		out[1] = String.valueOf(satelite.getCoordinatey());
		return out;

	}

}
