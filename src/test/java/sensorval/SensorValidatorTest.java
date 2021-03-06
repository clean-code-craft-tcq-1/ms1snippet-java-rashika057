package sensorval;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

public class SensorValidatorTest 
{
    @Test
    public void reportsErrorWhenSOCjumps()
    {
        Double[] readings = {0.0, 0.01, 0.5, 0.51};
        List<Double> socs = Arrays.asList(readings);
        assertTrue(SensorValidator.validateSocReadings(socs));
        
    }
    @Test
    public void reportsErrorWhenCurrentjumps()
    {
        Double[] readings = {0.03, 0.03, 0.03, 0.33};
        List<Double> currents = Arrays.asList(readings);
			assertFalse(SensorValidator.validateCurrentReadings(currents));
    }
    
   @Test(expected = IllegalArgumentException.class)
    public void reportsExceptionWhenCurrentReadingsNull()
    {
	   SensorValidator.validateCurrentReadings(null);
	   
    }
   
   @Test(expected = IllegalArgumentException.class)
   public void reportsExceptionWhenCurrentReadingsContainNull()
   {
	   Double[] readings = {0.03, 0.03,null, 0.03, 0.33};
       List<Double> currents = Arrays.asList(readings);
	   SensorValidator.validateCurrentReadings(currents);
	   
   }
}
