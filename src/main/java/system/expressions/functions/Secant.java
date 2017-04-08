package system.expressions.functions;

public class Secant {

    public static double calcSec(double arg) {

        if (Double.isInfinite(arg)) {
            throw new ArithmeticException("Impossible to calculate sec(infinity)");
        }

        if (Double.isNaN(arg)) {
            return Double.NaN;
        }

        double cos = Cosine.calcCos(arg);

        if (cos == 0)
            return Double.NaN;
        else
            return 1D / cos;

    }

}
