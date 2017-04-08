package system.expressions.functions.basic;

public class Sine {

    public static double calcSin(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate sin(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        arg = arg % (2 * Math.PI);

        double term = 1.0;
        double sum = 0.0;

        for (int i = 1; term != 0.0; i++) {
            term *= arg / i;
            sum += (~(i & 3) + 3) * (i & 1) * term;
        }

        return sum;

    }

}
