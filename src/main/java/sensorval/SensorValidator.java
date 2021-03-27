package sensorval;

import java.util.List;
import java.util.stream.IntStream;

import lombok.NonNull;

public class SensorValidator 
{
	private static final double SOC_MAX_DELTA = 0.5;
	
	private static final double CURRENT_MAX_DELTA = 0.1;
	
	public static boolean validateCurrentReadings(List<Double> values)  {
        return validateReadings(values,CURRENT_MAX_DELTA);
    }
	
	public static boolean validateSocReadings(List<Double> values)  {
        return validateReadings(values,SOC_MAX_DELTA);
    }
	
	public static boolean haveNoSuddenJump(double value, double nextValue, double maxDelta) {
        return (Math.abs(nextValue - value) <= maxDelta) ;
    }
        
    public static boolean validateReadings(@NonNull List<Double> values,double maxDelta)  {
    	return IntStream.range(0, values.size() - 1).allMatch(i -> haveNoSuddenJump(values.get(i), values.get(i + 1), maxDelta));
    }  
}
