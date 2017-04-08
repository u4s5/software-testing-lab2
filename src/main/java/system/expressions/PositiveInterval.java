package system.expressions;

import static system.expressions.functions.Logarithm.calcLog;

public class PositiveInterval {

    public static double calc(double arg) {

        return (((((calcLog(2, arg) * calcLog(10, arg)) * calcLog(3, arg)) * ((calcLog(3, arg) + calcLog(10, arg)) * calcLog(2, arg))) + calcLog(5, arg)) * (((calcLog(3, arg) - calcLog(10, arg)) / calcLog(3, arg)) / calcLog(10, arg)));

    }

}
