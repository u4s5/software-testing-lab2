package layer1;

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
import system.expressions.PositiveInterval;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest({NegativeInterval.class, PositiveInterval.class})
public class SystemTest {

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
                {"Testing x = -15pi/8", 3.9314, -15 * Math.PI / 8},


                {"Testing x = 1", Double.NaN, 1D},
                {"Testing x = 1 - delta", 1.16624, 1 - DELTA},
                {"Testing x = 1 + delta", 1.16624, 1 + DELTA},

                {"Testing x = 0", Double.NaN, 0D},
                {"Testing x = 0 + delta", 3.82749, DELTA},

                {"Testing x = 0.1", 1.46193, 0.1},
                {"Testing x = 0.75", 1.17085, 0.75},

                {"Testing x = 5", 1.3107, 5D},
                {"Testing x = 100000", 8.55861, 100000D}

        });
    }

    @Before
    public void mockNegativeInterval() {
        PowerMockito.mockStatic(NegativeInterval.class);

        BDDMockito.given(NegativeInterval.calc(-Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(NegativeInterval.calc(-Math.PI - DELTA)).willReturn(0.499999);
        BDDMockito.given(NegativeInterval.calc(-Math.PI + DELTA)).willReturn(0.499999);

        BDDMockito.given(NegativeInterval.calc(-Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(NegativeInterval.calc(-Math.PI / 2 - DELTA)).willReturn(0.49975);
        BDDMockito.given(NegativeInterval.calc(-Math.PI / 2 + DELTA)).willReturn(0.50025);

        BDDMockito.given(NegativeInterval.calc(-3 * Math.PI / 2)).willReturn(Double.NaN);
        BDDMockito.given(NegativeInterval.calc(-3 * Math.PI / 2 - DELTA)).willReturn(0.50025);
        BDDMockito.given(NegativeInterval.calc(-3 * Math.PI / 2 + DELTA)).willReturn(0.49975);

        BDDMockito.given(NegativeInterval.calc(0D)).willReturn(Double.NaN);
        BDDMockito.given(NegativeInterval.calc(-DELTA)).willReturn(666666D);

        BDDMockito.given(NegativeInterval.calc(-2 * Math.PI)).willReturn(Double.NaN);
        BDDMockito.given(NegativeInterval.calc(-2 * Math.PI - DELTA)).willReturn(666666D);
        BDDMockito.given(NegativeInterval.calc(-2 * Math.PI + DELTA)).willReturn(666666D);


        BDDMockito.given(NegativeInterval.calc(-Math.PI / 4)).willReturn(0.945903);
        BDDMockito.given(NegativeInterval.calc(-Math.PI / 8)).willReturn(3.9314);

        BDDMockito.given(NegativeInterval.calc(-3 * Math.PI / 4)).willReturn(0.339811);
        BDDMockito.given(NegativeInterval.calc(-5 * Math.PI / 4)).willReturn(0.339811);

        BDDMockito.given(NegativeInterval.calc(-7 * Math.PI / 4)).willReturn(0.945903);
        BDDMockito.given(NegativeInterval.calc(-15 * Math.PI / 8)).willReturn(3.9314);
    }

    @Before
    public void mockPositiveInterval() {
        PowerMockito.mockStatic(PositiveInterval.class);

        BDDMockito.given(PositiveInterval.calc(1D)).willReturn(Double.NaN);
        BDDMockito.given(PositiveInterval.calc(1 - DELTA)).willReturn(1.16624);
        BDDMockito.given(PositiveInterval.calc(1 + DELTA)).willReturn(1.16624);

        BDDMockito.given(PositiveInterval.calc(0D)).willReturn(Double.NaN);
        BDDMockito.given(PositiveInterval.calc(DELTA)).willReturn(3.82749);

        BDDMockito.given(PositiveInterval.calc(0.1)).willReturn(1.46193);
        BDDMockito.given(PositiveInterval.calc(0.75)).willReturn(1.17085);

        BDDMockito.given(PositiveInterval.calc(5D)).willReturn(1.3107);
        BDDMockito.given(PositiveInterval.calc(100000D)).willReturn(8.55861);
    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(System.calc(arg)));
        else
            assertEquals(message, expectedResult, System.calc(arg), DELTA);
    }

}
