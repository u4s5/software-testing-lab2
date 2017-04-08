package system.expressions.functions;

import system.expressions.functions.basic.Sine;

public class Cotangent {

    public static double calcCot(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate cot(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        double sin = Sine.calcSin(arg);

        if (sin == 0)
            return Double.NaN;
        else
            return Cosine.calcCos(arg) / sin;

    }

}
