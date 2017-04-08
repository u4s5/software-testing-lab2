package system.expressions.functions;

import system.expressions.functions.basic.NaturalLogarithm;

public class Logarithm {

    public static double calcLog(int base, double arg) {

        return NaturalLogarithm.calcLn(arg) / NaturalLogarithm.calcLn(base);

    }

}
