package sensorval;

import java.util.List;

import lombok.NonNull;

public class SensorValidator 
{
    public static boolean conditionDifferenceCrossedMaxDelta(double value, double nextValue, double maxDelta) {
        return (Math.abs(nextValue - value) <= maxDelta) ;
    }
    public static boolean validateSOCreadings(@NonNull List<Double> values) {
    	return validateReadings(values,0.5);
    }
    public static boolean validateCurrentreadings(@NonNull List<Double> values) {
    	return validateReadings(values,0.1);
    }
    
    public static boolean validateReadings(@NonNull List<Double> values,double maxDelta) {
        int lastButOneIndex = values.size() - 1;
        for(int i = 0; i < lastButOneIndex; i++) {
            if(!conditionDifferenceCrossedMaxDelta(values.get(i), values.get(i + 1), maxDelta)) {
            return false;
            }
        }
        return true;
    }
}
