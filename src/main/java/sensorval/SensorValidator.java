package sensorval;

import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

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
	
	/**
	 * Returns a boolean, true if no jump otherwise false.
	 *
	 * @param  values the reading lists, which must be not null and contains non-null values.
	 * @param	maxDelta, maximum limit for consecutive reading difference
	 * @throws IllegalArgumentException if values is null or contains non-null values.
	 */        
    public static boolean validateReadings(List<Double> values,double maxDelta)  {
    	isListValid(values);
    	return IntStream.range(0, values.size() - 1).allMatch(i -> haveNoSuddenJump(values.get(i), values.get(i + 1), maxDelta));
    } 
        
    public static void isListValid(List<Double> list) {
    	if(Objects.isNull(list) || list.contains(null)) {
    		throw new IllegalArgumentException();
    	}    	
    }
}
