package co.com.mercadolibre.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class PosicionServiceTest {
	
	@Autowired
    private IPosicionService posicionService;

	@Test
	public void whenDistanceAndPositionAreValidShoulddReturnAValidPosition() {
		
		double[][] coordinatesSatellites = new double[][]{{-500.0, -200.0}, {100.0, -100.0}, {500.0, 100.0}};
		double[] distanceSatellites = new double[]{100.0, 115.5, 142.7};
	    double[] validateResult = new double[]{-58.315252587138595, -69.55141837312165};
	    double[] validateTest=posicionService.getLocation(coordinatesSatellites, distanceSatellites);
		
	    for (int i = 0; i < validateResult.length; i++) 
            assertEquals(validateTest[i], validateResult[i]);
	}

	@Test
	public void whenDistanceAndPositionAreValidShouldReturnAValidPositionFor() {
		
		double[][] coordinatesSatellites = new double[][]{{-500.0, -200.0}, {100.0, -100.0}, {500.0, 100.0}, {600.0, 200.0}};
		double[] distanceSatellites = new double[]{100.0, 115.5, 142.7, 200.8};
	    double[] validateResult = new double[]{-10.96631017245394, -39.54218713459665};
	    double[] validateTest=posicionService.getLocation(coordinatesSatellites, distanceSatellites);
		
	    for (int i = 0; i < validateResult.length; i++) 
            assertEquals(validateTest[i], validateResult[i]);
	}
}
