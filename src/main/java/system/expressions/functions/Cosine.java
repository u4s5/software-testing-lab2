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

        double cos = Math.sqrt(1 - Math.pow(Sine.calcSin(arg), 2));
        double mod = Math.abs(arg % (Math.PI * 2));
        if (mod >= Math.PI / 2 && mod <= 3 * Math.PI / 2) {
            cos = -cos;
        }
        return cos;

    }

}
