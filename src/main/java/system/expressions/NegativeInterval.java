package system.expressions;

import static system.expressions.functions.Cosecant.calcCsc;
import static system.expressions.functions.Cosine.calcCos;
import static system.expressions.functions.Cotangent.calcCot;
import static system.expressions.functions.Secant.calcSec;
import static system.expressions.functions.Tangent.calcTan;
import static system.expressions.functions.basic.Sine.calcSin;

public class NegativeInterval {

    public static double calc(double arg) {

        return (((((calcCos(arg) / calcSec(arg)) - (Math.pow(calcCsc(arg), 2))) * calcCot(arg)) /
                (calcCot(arg) - calcCos(arg))) / ((calcCsc(arg) - (calcCot(arg) - calcSin(arg))) /
                ((calcSin(arg) / calcCsc(arg)) - (calcTan(arg) * calcCos(arg)))));

    }

}
