package system;

import system.expressions.NegativeInterval;
import system.expressions.PositiveInterval;

public class System {

    public static double calc(double arg) {

        if (arg <= 0)
            return NegativeInterval.calc(arg);
        else
            return PositiveInterval.calc(arg);

    }

}
