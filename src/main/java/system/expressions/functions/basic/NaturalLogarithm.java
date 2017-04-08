package system.expressions.functions.basic;

public class NaturalLogarithm {

    private static final double PRECISION = 1e-5;

    public static double calcLn(double x) {

        if (x < 0D) {
            throw new ArithmeticException("Impossible to calculate ln() of negative number");
        }

        if (x == 0D) {
            return Double.NEGATIVE_INFINITY;
        }

        if (x == Double.POSITIVE_INFINITY) {
            return Double.POSITIVE_INFINITY;
        }

        double result = 0D;
        final double a = (x - 1D) / (x + 1D);
        double current;
        double numerator = a;
        int k = 1;

        do {
            current = numerator / k;
            result += current;
            k += 2;
            numerator *= a * a;
        } while (Math.abs(current) >= PRECISION / 100000);

        return 2 * result;

    }

}
