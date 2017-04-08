package system.expressions;

import system.expressions.functions.Logarithm;
import system.expressions.functions.basic.NaturalLogarithm;

public class PositiveInterval {

    public static double calc(double arg) {

        return (((((Logarithm.calcLog(2, arg) + Logarithm.calcLog(10, arg))
                / Math.pow(NaturalLogarithm.calcLn(arg), 2)) + NaturalLogarithm.calcLn(arg))
                - Logarithm.calcLog(3, arg)) * Logarithm.calcLog(5, arg));

    }

}
