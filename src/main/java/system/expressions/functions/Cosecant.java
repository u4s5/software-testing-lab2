package system.expressions.functions;

import system.expressions.functions.basic.Sine;

public class Cosecant {

    public static double calcCsc(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate csc(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        double sin = Sine.calcSin(arg);

        if (sin == 0)
            return Double.NaN;
        else
            return 1D / sin;

    }

}
