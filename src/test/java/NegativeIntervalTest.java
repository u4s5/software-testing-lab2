import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import system.System;
import system.expressions.NegativeInterval;
import system.expressions.functions.*;
import system.expressions.functions.basic.Sine;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest({Cosecant.class, Cotangent.class, Tangent.class, Secant.class, Cosine.class, Sine.class})
public class NegativeIntervalTest {

    private static final double DELTA = 1e-3;

    @Parameterized.Parameter
    public String message;
    @Parameterized.Parameter(1)
    public Double expectedResult;
    @Parameterized.Parameter(2)
    public Double arg;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{

                {"Testing x = -pi", Double.NaN, -Math.PI},
                {"Testing x = -pi - delta", 0.499999, -Math.PI - DELTA},
                {"Testing x = -pi + delta", 0.499999, -Math.PI + DELTA},

                {"Testing x = -pi/2", Double.NaN, -Math.PI / 2},
                {"Testing x = -pi/2 - delta", 0.49975, -Math.PI / 2 - DELTA},
                {"Testing x = -pi/2 + delta", 0.50025, -Math.PI / 2 + DELTA},

                {"Testing x = -3pi/2", Double.NaN, -3 * Math.PI / 2},
                {"Testing x = -3pi/2 - delta", 0.50025, -3 * Math.PI / 2 - DELTA},
                {"Testing x = -3pi/2 + delta", 0.49975, -3 * Math.PI / 2 + DELTA},

                {"Testing x = 0", Double.NaN, 0D},
                {"Testing x = 0 - delta", 666666D, -DELTA},

                {"Testing x = -2pi", Double.NaN, -2 * Math.PI},
                {"Testing x = -2pi - delta", 666666D, -2 * Math.PI - DELTA},
                {"Testing x = -2pi + delta", 666666D, -2 * Math.PI + DELTA},


                {"Testing x = -pi/4", 0.945903, -Math.PI / 4},
                {"Testing x = -pi/8", 3.9314, -Math.PI / 8},

                {"Testing x = -3pi/4", 0.339811, -3 * Math.PI / 4},
                {"Testing x = -5pi/4", 0.339811, -5 * Math.PI / 4},

                {"Testing x = -7pi/4", 0.945903, -7 * Math.PI / 4},
                {"Testing x = -15pi/8", 3.9314, -15 * Math.PI / 8}

        });
    }

    @Before
    public void mockSine() {
        PowerMockito.mockStatic(Sine.class);

        BDDMockito.given(Sine.calcSin(-Math.PI)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(-Math.PI - DELTA)).willReturn(0.001);
        BDDMockito.given(Sine.calcSin(-Math.PI + DELTA)).willReturn(-0.001);

        BDDMockito.given(Sine.calcSin(-Math.PI / 2)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(-Math.PI / 2 - DELTA)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(-Math.PI / 2 + DELTA)).willReturn(-1D);

        BDDMockito.given(Sine.calcSin(-3 * Math.PI / 2)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(-3 * Math.PI / 2 - DELTA)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(-3 * Math.PI / 2 + DELTA)).willReturn(1D);

        BDDMockito.given(Sine.calcSin(0D)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(-DELTA)).willReturn(-0.001);

        BDDMockito.given(Sine.calcSin(-2 * Math.PI)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(-2 * Math.PI - DELTA)).willReturn(-0.001);
        BDDMockito.given(Sine.calcSin(-2 * Math.PI + DELTA)).willReturn(0.001);


        BDDMockito.given(Sine.calcSin(-Math.PI / 4)).willReturn(-0.707107);
        BDDMockito.given(Sine.calcSin(-Math.PI / 8)).willReturn(-0.382683);

        BDDMockito.given(Sine.calcSin(-3 * Math.PI / 4)).willReturn(-0.707107);
        BDDMockito.given(Sine.calcSin(-5 * Math.PI / 4)).willReturn(-0.707107);

        BDDMockito.given(Sine.calcSin(-7 * Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Sine.calcSin(-15 * Math.PI / 8)).willReturn(0.382683);
    }

    @Before
    public void mockCosine() {
        PowerMockito.mockStatic(Cosine.class);

        BDDMockito.given(Cosine.calcCos(-Math.PI)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(-Math.PI - DELTA)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(-Math.PI + DELTA)).willReturn(-1D);

        BDDMockito.given(Cosine.calcCos(-Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 2 - DELTA)).willReturn(-0.001);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 2 + DELTA)).willReturn(0.001);

        BDDMockito.given(Cosine.calcCos(-3 * Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(-3 * Math.PI / 2 - DELTA)).willReturn(0.001);
        BDDMockito.given(Cosine.calcCos(-3 * Math.PI / 2 + DELTA)).willReturn(-0.001);

        BDDMockito.given(Cosine.calcCos(0D)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(-DELTA)).willReturn(1D);

        BDDMockito.given(Cosine.calcCos(-2 * Math.PI)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(-2 * Math.PI - DELTA)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(-2 * Math.PI + DELTA)).willReturn(1D);


        BDDMockito.given(Cosine.calcCos(-Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 8)).willReturn(0.92388);

        BDDMockito.given(Cosine.calcCos(-3 * Math.PI / 4)).willReturn(-0.707107);
        BDDMockito.given(Cosine.calcCos(-5 * Math.PI / 4)).willReturn(-0.707107);

        BDDMockito.given(Cosine.calcCos(-7 * Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Cosine.calcCos(-15 * Math.PI / 8)).willReturn(0.92388);
    }

    @Before
    public void mockSecant() {
        PowerMockito.mockStatic(Secant.class);

        BDDMockito.given(Secant.calcSec(-Math.PI)).willReturn(-1D);
        BDDMockito.given(Secant.calcSec(-Math.PI - DELTA)).willReturn(-1D);
        BDDMockito.given(Secant.calcSec(-Math.PI + DELTA)).willReturn(-1D);

        BDDMockito.given(Secant.calcSec(-Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(Secant.calcSec(-Math.PI / 2 - DELTA)).willReturn(-1000D);
        BDDMockito.given(Secant.calcSec(-Math.PI / 2 + DELTA)).willReturn(1000D);

        BDDMockito.given(Secant.calcSec(-3 * Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(Secant.calcSec(-3 * Math.PI / 2 - DELTA)).willReturn(1000D);
        BDDMockito.given(Secant.calcSec(-3 * Math.PI / 2 + DELTA)).willReturn(-1000D);

        BDDMockito.given(Secant.calcSec(0D)).willReturn(1D);
        BDDMockito.given(Secant.calcSec(-DELTA)).willReturn(1D);

        BDDMockito.given(Secant.calcSec(-2 * Math.PI)).willReturn(1D);
        BDDMockito.given(Secant.calcSec(-2 * Math.PI - DELTA)).willReturn(1D);
        BDDMockito.given(Secant.calcSec(-2 * Math.PI + DELTA)).willReturn(1D);


        BDDMockito.given(Secant.calcSec(-Math.PI / 4)).willReturn(1.41421);
        BDDMockito.given(Secant.calcSec(-Math.PI / 8)).willReturn(1.08239);

        BDDMockito.given(Secant.calcSec(-3 * Math.PI / 4)).willReturn(-1.41421);
        BDDMockito.given(Secant.calcSec(-5 * Math.PI / 4)).willReturn(-1.41421);

        BDDMockito.given(Secant.calcSec(-7 * Math.PI / 4)).willReturn(1.41421);
        BDDMockito.given(Secant.calcSec(-15 * Math.PI / 8)).willReturn(1.08239);
    }

    @Before
    public void mockCosecant() {
        PowerMockito.mockStatic(Cosecant.class);

        BDDMockito.given(Cosecant.calcCsc(-Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(Cosecant.calcCsc(-Math.PI - DELTA)).willReturn(1000D);
        BDDMockito.given(Cosecant.calcCsc(-Math.PI + DELTA)).willReturn(-1000D);

        BDDMockito.given(Cosecant.calcCsc(-Math.PI / 2)).willReturn(-1D);
        BDDMockito.given(Cosecant.calcCsc(-Math.PI / 2 - DELTA)).willReturn(-1D);
        BDDMockito.given(Cosecant.calcCsc(-Math.PI / 2 + DELTA)).willReturn(-1D);

        BDDMockito.given(Cosecant.calcCsc(-3 * Math.PI / 2)).willReturn(1D);
        BDDMockito.given(Cosecant.calcCsc(-3 * Math.PI / 2 - DELTA)).willReturn(1D);
        BDDMockito.given(Cosecant.calcCsc(-3 * Math.PI / 2 + DELTA)).willReturn(1D);

        BDDMockito.given(Cosecant.calcCsc(0D)).willReturn(Double.NaN);
        BDDMockito.given(Cosecant.calcCsc(-DELTA)).willReturn(-1000D);

        BDDMockito.given(Cosecant.calcCsc(-2 * Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(Cosecant.calcCsc(-2 * Math.PI - DELTA)).willReturn(-1000D);
        BDDMockito.given(Cosecant.calcCsc(-2 * Math.PI + DELTA)).willReturn(1000D);


        BDDMockito.given(Cosecant.calcCsc(-Math.PI / 4)).willReturn(-1.41421);
        BDDMockito.given(Cosecant.calcCsc(-Math.PI / 8)).willReturn(-2.61313);

        BDDMockito.given(Cosecant.calcCsc(-3 * Math.PI / 4)).willReturn(-1.41421);
        BDDMockito.given(Cosecant.calcCsc(-5 * Math.PI / 4)).willReturn(1.41421);

        BDDMockito.given(Cosecant.calcCsc(-7 * Math.PI / 4)).willReturn(1.41421);
        BDDMockito.given(Cosecant.calcCsc(-15 * Math.PI / 8)).willReturn(2.61313);
    }

    @Before
    public void mockTangent() {
        PowerMockito.mockStatic(Tangent.class);

        BDDMockito.given(Tangent.calcTan(-Math.PI)).willReturn(0D);
        BDDMockito.given(Tangent.calcTan(-Math.PI - DELTA)).willReturn(-0.001);
        BDDMockito.given(Tangent.calcTan(-Math.PI + DELTA)).willReturn(0.001);

        BDDMockito.given(Tangent.calcTan(-Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(Tangent.calcTan(-Math.PI / 2 - DELTA)).willReturn(1000D);
        BDDMockito.given(Tangent.calcTan(-Math.PI / 2 + DELTA)).willReturn(-1000D);

        BDDMockito.given(Tangent.calcTan(-3 * Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(Tangent.calcTan(-3 * Math.PI / 2 - DELTA)).willReturn(1000D);
        BDDMockito.given(Tangent.calcTan(-3 * Math.PI / 2 + DELTA)).willReturn(-1000D);

        BDDMockito.given(Tangent.calcTan(0D)).willReturn(0D);
        BDDMockito.given(Tangent.calcTan(-DELTA)).willReturn(-0.001);

        BDDMockito.given(Tangent.calcTan(-2 * Math.PI)).willReturn(0D);
        BDDMockito.given(Tangent.calcTan(-2 * Math.PI - DELTA)).willReturn(-0.001);
        BDDMockito.given(Tangent.calcTan(-2 * Math.PI + DELTA)).willReturn(0.001);


        BDDMockito.given(Tangent.calcTan(-Math.PI / 4)).willReturn(-1D);
        BDDMockito.given(Tangent.calcTan(-Math.PI / 8)).willReturn(-0.414214);

        BDDMockito.given(Tangent.calcTan(-3 * Math.PI / 4)).willReturn(1D);
        BDDMockito.given(Tangent.calcTan(-5 * Math.PI / 4)).willReturn(-1D);

        BDDMockito.given(Tangent.calcTan(-7 * Math.PI / 4)).willReturn(1D);
        BDDMockito.given(Tangent.calcTan(-15 * Math.PI / 8)).willReturn(0.414214);
    }

    @Before
    public void mockCotangent() {
        PowerMockito.mockStatic(Cotangent.class);

        BDDMockito.given(Cotangent.calcCot(-Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(Cotangent.calcCot(-Math.PI - DELTA)).willReturn(-1000D);
        BDDMockito.given(Cotangent.calcCot(-Math.PI + DELTA)).willReturn(1000D);

        BDDMockito.given(Cotangent.calcCot(-Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cotangent.calcCot(-Math.PI / 2 - DELTA)).willReturn(0.001);
        BDDMockito.given(Cotangent.calcCot(-Math.PI / 2 + DELTA)).willReturn(-0.001);

        BDDMockito.given(Cotangent.calcCot(-3 * Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cotangent.calcCot(-3 * Math.PI / 2 - DELTA)).willReturn(0.001);
        BDDMockito.given(Cotangent.calcCot(-3 * Math.PI / 2 + DELTA)).willReturn(-0.001);

        BDDMockito.given(Cotangent.calcCot(0D)).willReturn(Double.NaN);
        BDDMockito.given(Cotangent.calcCot(-DELTA)).willReturn(-1000D);

        BDDMockito.given(Cotangent.calcCot(-2 * Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(Cotangent.calcCot(-2 * Math.PI - DELTA)).willReturn(-1000D);
        BDDMockito.given(Cotangent.calcCot(-2 * Math.PI + DELTA)).willReturn(1000D);


        BDDMockito.given(Cotangent.calcCot(-Math.PI / 4)).willReturn(-1D);
        BDDMockito.given(Cotangent.calcCot(-Math.PI / 8)).willReturn(-2.41421);

        BDDMockito.given(Cotangent.calcCot(-3 * Math.PI / 4)).willReturn(1D);
        BDDMockito.given(Cotangent.calcCot(-5 * Math.PI / 4)).willReturn(-1D);

        BDDMockito.given(Cotangent.calcCot(-7 * Math.PI / 4)).willReturn(1D);
        BDDMockito.given(Cotangent.calcCot(-15 * Math.PI / 8)).willReturn(2.41421);
    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(System.calc(arg)));
        else
            assertEquals(message, expectedResult, NegativeInterval.calc(arg), DELTA);
    }

}
