package system.expressions.functions;

import system.expressions.functions.basic.Sine;

public class Tangent {

    public static double calcTan(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate tan(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        double cos = Cosine.calcCos(arg);

        if (cos == 0)
            return Double.NaN;
        else
            return Sine.calcSin(arg) / cos;

    }

}
