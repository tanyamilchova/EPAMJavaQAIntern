package edu.epam.fop.lambdas;

import java.util.Comparator;

public final class RadianComparator {

    /*
     * Compares 2 angles (passed in radians). The angle counts from 0 up to 2π, the period must
     * be ignored, i.e. if angle is greater than 2π, then it must be converted to the range [0; 2π).
     * Precision must be 0.001 (delta), so if |a - b| < 0.001, then a == b.
     * 0 == 2π
     */
    public static Comparator<Double> get() {
        return (o1, o2) -> {
            if (o1 == null && o2 == null) {
                return 0;
            } else if (o1 == null) {
                return -1;
            } else if (o2 == null) {
                return 1;
            }
            double o1Angle = calculateRadianAngle(o1);
            double o2Angle = calculateRadianAngle(o2);
            int o1Period = calculatePeriod(o1);
            int o2Period = calculatePeriod(o2);


        if(o1 !=0.0 && o2 !=0.0 &&
                (Math.abs(o1Period - o2Period) % 2 == 0) || (isInPrecisionRate(o1Angle, o2Angle)) ){
            return 0;
        }else {
            if(o1Angle < o2Angle){
                return -1;
            }
        }
        return 1;
        };
    }

    public static double calculateRadianAngle(double angle){
        if(angle > Math.PI){
          angle= angle % Math.PI;
        }
        return (double) Math.round(angle*10000)/10000;
      }
      public static int calculatePeriod(double angle){
        int period=0;
        if(angle >= Math.PI){
          period =  ( (int) angle / (int) Math.PI);
        }
        return period;

      }

     static boolean isInPrecisionRate(double o1, double o2){
       double precisionRate = Math.abs( Math.abs(o1) - Math.abs(o2));
       return (precisionRate >=0  && (precisionRate < 0.001));
      }
}
