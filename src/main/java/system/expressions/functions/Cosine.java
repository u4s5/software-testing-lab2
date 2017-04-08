package system.expressions.functions;

import system.expressions.functions.basic.Sine;

public class Cosine {

    public static double calcCos(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate cos(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        return Math.sqrt(1 - Math.pow(Sine.calcSin(arg), 2));

    }

}
