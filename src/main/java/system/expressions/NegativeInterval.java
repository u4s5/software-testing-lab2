package system.expressions;

import system.expressions.functions.*;
import system.expressions.functions.basic.Sine;

public class NegativeInterval {

    public static double calc(double arg) {

        return (((((Cosine.calcCos(arg) / Secant.calcSec(arg)) - Math.pow(Cosecant.calcCsc(arg), 2))
                * Cotangent.calcCot(arg)) / (Cotangent.calcCot(arg) - Cosine.calcCos(arg)))
                / ((Cosecant.calcCsc(arg) - (Cotangent.calcCot(arg) - Sine.calcSin(arg)))
                / ((Sine.calcSin(arg) / Cosecant.calcCsc(arg)) - (Tangent.calcTan(arg)
                * Cosine.calcCos(arg)))));

    }

}
