package layer2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import system.System;
import system.expressions.functions.Logarithm;
import system.expressions.functions.basic.NaturalLogarithm;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest({NaturalLogarithm.class, Logarithm.class})
public class PositiveIntervalTest {

    private static final double DELTA = 1e-2;

    @Parameterized.Parameter
    public String message;
    @Parameterized.Parameter(1)
    public Double expectedResult;
    @Parameterized.Parameter(2)
    public Double arg;

    @Parameterized.Parameters
    public static Collection<Object[]> parameters() {
        return Arrays.asList(new Object[][]{

                {"Testing x = 1", Double.NaN, 1D},
                {"Testing x = 1 - delta", 1.16624, 1 - DELTA},
                {"Testing x = 1 + delta", 1.16624, 1 + DELTA},

                {"Testing x = 0", Double.NaN, 0D},
                {"Testing x = 0 + delta", Double.NaN, 0D},

                {"Testing x = 0.1", 1.46193, 0.1},
                {"Testing x = 0.75", 1.17085, 0.75},

                {"Testing x = 5", 1.3107, 5D},
                {"Testing x = 100000", 2.34902, 100D}

        });
    }

    public void mockNaturalLogarithm() {
        PowerMockito.mockStatic(NaturalLogarithm.class);

        BDDMockito.given(NaturalLogarithm.calcLn(1D)).willReturn(0D);
        BDDMockito.given(NaturalLogarithm.calcLn(1 - DELTA)).willReturn(-0.0010005);
        BDDMockito.given(NaturalLogarithm.calcLn(1 + DELTA)).willReturn(0.0009995);

        BDDMockito.given(NaturalLogarithm.calcLn(0D)).willReturn(Double.NaN);
        BDDMockito.given(NaturalLogarithm.calcLn(DELTA)).willReturn(-6.90776);

        BDDMockito.given(NaturalLogarithm.calcLn(0.1)).willReturn(-2.30259);
        BDDMockito.given(NaturalLogarithm.calcLn(0.75)).willReturn(-0.287682);

        BDDMockito.given(NaturalLogarithm.calcLn(5D)).willReturn(1.60944);
        BDDMockito.given(NaturalLogarithm.calcLn(100D)).willReturn(4.60517);
    }

    public void mockLogarithm() {
        PowerMockito.mockStatic(Logarithm.class);

        BDDMockito.given(Logarithm.calcLog(2, 1D)).willReturn(0D);
        BDDMockito.given(Logarithm.calcLog(2, 1 - DELTA)).willReturn(-0.00144342);
        BDDMockito.given(Logarithm.calcLog(2, 1 + DELTA)).willReturn(0.00144197);

        BDDMockito.given(Logarithm.calcLog(2, 0D)).willReturn(Double.NaN);
        BDDMockito.given(Logarithm.calcLog(2, DELTA)).willReturn(-9.96578);

        BDDMockito.given(Logarithm.calcLog(2, 0.1)).willReturn(-3.32193);
        BDDMockito.given(Logarithm.calcLog(2, 0.75)).willReturn(-0.415037);

        BDDMockito.given(Logarithm.calcLog(2, 5D)).willReturn(2.32193);
        BDDMockito.given(Logarithm.calcLog(2, 100D)).willReturn(6.64386);


        BDDMockito.given(Logarithm.calcLog(3, 1D)).willReturn(0D);
        BDDMockito.given(Logarithm.calcLog(3, 1 - DELTA)).willReturn(-0.000910695);
        BDDMockito.given(Logarithm.calcLog(3, 1 + DELTA)).willReturn(0.000909784);

        BDDMockito.given(Logarithm.calcLog(3, 0D)).willReturn(Double.NaN);
        BDDMockito.given(Logarithm.calcLog(3, DELTA)).willReturn(-6.28771);

        BDDMockito.given(Logarithm.calcLog(3, 0.1)).willReturn(-2.0959);
        BDDMockito.given(Logarithm.calcLog(3, 0.75)).willReturn(-0.26186);

        BDDMockito.given(Logarithm.calcLog(3, 5D)).willReturn(1.46497);
        BDDMockito.given(Logarithm.calcLog(3, 100D)).willReturn(4.19181);


        BDDMockito.given(Logarithm.calcLog(5, 1D)).willReturn(0D);
        BDDMockito.given(Logarithm.calcLog(5, 1 - DELTA)).willReturn(-0.000621646);
        BDDMockito.given(Logarithm.calcLog(5, 1 + DELTA)).willReturn(0.000621646);

        BDDMockito.given(Logarithm.calcLog(5, 0D)).willReturn(Double.NaN);
        BDDMockito.given(Logarithm.calcLog(5, DELTA)).willReturn(-4.29203);

        BDDMockito.given(Logarithm.calcLog(5, 0.1)).willReturn(-1.43068);
        BDDMockito.given(Logarithm.calcLog(5, 0.75)).willReturn(-0.178747);

        BDDMockito.given(Logarithm.calcLog(5, 5D)).willReturn(1D);
        BDDMockito.given(Logarithm.calcLog(5, 100D)).willReturn(2.86135);


        BDDMockito.given(Logarithm.calcLog(10, 1D)).willReturn(0D);
        BDDMockito.given(Logarithm.calcLog(10, 1 - DELTA)).willReturn(-0.000434512);
        BDDMockito.given(Logarithm.calcLog(10, 1 + DELTA)).willReturn(0.000434077);

        BDDMockito.given(Logarithm.calcLog(10, 0D)).willReturn(Double.NaN);
        BDDMockito.given(Logarithm.calcLog(10, DELTA)).willReturn(-3D);

        BDDMockito.given(Logarithm.calcLog(10, 0.1)).willReturn(-1D);
        BDDMockito.given(Logarithm.calcLog(10, 0.75)).willReturn(-0.124939);

        BDDMockito.given(Logarithm.calcLog(10, 5D)).willReturn(0.69897);
        BDDMockito.given(Logarithm.calcLog(10, 100D)).willReturn(2D);
    }

    @Test
    public void testPositiveIntervalWithStubs() {
        mockLogarithm();
        mockNaturalLogarithm();
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(System.calc(arg)));
        else
            assertEquals(message, expectedResult, System.calc(arg), DELTA);
    }

    @Test
    public void testPositiveIntervalWithoutStubs() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(System.calc(arg)));
        else
            assertEquals(message, expectedResult, System.calc(arg), DELTA);
    }

}
