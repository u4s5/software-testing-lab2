import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import system.expressions.functions.Cosecant;
import system.expressions.functions.basic.Sine;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest(Sine.class)
public class CosecantTest {

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

                {"Testing x = -pi/2", -1D, -Math.PI / 2},
                {"Testing x = -pi/2 - delta", -1D, -Math.PI / 2 - DELTA},
                {"Testing x = -pi/2 + delta", -1D, -Math.PI / 2 + DELTA},

                {"Testing x = 0", Double.NaN, 0D},
                {"Testing x = 0 - delta", -1000D, -DELTA},
                {"Testing x = 0 + delta", 1000D, DELTA},

                {"Testing x = pi/2", 1D, Math.PI / 2},
                {"Testing x = pi/2 - delta", 1D, Math.PI / 2 - DELTA},
                {"Testing x = pi/2 + delta", 1D, Math.PI / 2 + DELTA},

                {"Testing x = pi", Double.NaN, Math.PI},
                {"Testing x = pi - delta", 1000D, Math.PI - DELTA},
                {"Testing x = pi + delta", -1000D, Math.PI + DELTA},

                {"Testing x = 3pi/2", -1D, 3 * Math.PI / 2},
                {"Testing x = 3pi/2 - delta", -1D, 3 * Math.PI / 2 - DELTA},
                {"Testing x = 3pi/2 + delta", -1D, 3 * Math.PI / 2 + DELTA},


                {"Testing x = -pi/5", -1.7013, -Math.PI / 5},
                {"Testing x = -pi/7", -2.30476, -Math.PI / 7},

                {"Testing x = pi/4", 1.41421, Math.PI / 4},
                {"Testing x = pi/6", 2D, Math.PI / 6},

                {"Testing x = 3pi/4", 1.41421, 3 * Math.PI / 4},
                {"Testing x = 6pi/7", 2.30476, 6 * Math.PI / 7},

                {"Testing x = 11pi/10", -3.23607, 11 * Math.PI / 10},
                {"Testing x = 14pi/10", -1.05146, 14 * Math.PI / 10}

        });
    }

    @Before
    public void mockSine() {
        PowerMockito.mockStatic(Sine.class);

        BDDMockito.given(Sine.calcSin(-Math.PI / 2)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(-Math.PI / 2 - DELTA)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(-Math.PI / 2 + DELTA)).willReturn(-1D);

        BDDMockito.given(Sine.calcSin(0D)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(-DELTA)).willReturn(-0.001);
        BDDMockito.given(Sine.calcSin(DELTA)).willReturn(0.001);

        BDDMockito.given(Sine.calcSin(Math.PI / 2)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(Math.PI / 2 - DELTA)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(Math.PI / 2 + DELTA)).willReturn(1D);

        BDDMockito.given(Sine.calcSin(Math.PI)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(Math.PI - DELTA)).willReturn(0.001);
        BDDMockito.given(Sine.calcSin(Math.PI + DELTA)).willReturn(-0.001);

        BDDMockito.given(Sine.calcSin(3 * Math.PI / 2)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(3 * Math.PI / 2 - DELTA)).willReturn(-1D);
        BDDMockito.given(Sine.calcSin(3 * Math.PI / 2 + DELTA)).willReturn(-1D);


        BDDMockito.given(Sine.calcSin(-Math.PI / 5)).willReturn(-0.587785);
        BDDMockito.given(Sine.calcSin(-Math.PI / 7)).willReturn(-0.433884);

        BDDMockito.given(Sine.calcSin(Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Sine.calcSin(Math.PI / 6)).willReturn(0.5);

        BDDMockito.given(Sine.calcSin(3 * Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Sine.calcSin(6 * Math.PI / 7)).willReturn(0.433884);

        BDDMockito.given(Sine.calcSin(11 * Math.PI / 10)).willReturn(-0.309017);
        BDDMockito.given(Sine.calcSin(14 * Math.PI / 10)).willReturn(-0.951057);

    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(Cosecant.calcCsc(arg)));
        else
            assertEquals(message, expectedResult, Cosecant.calcCsc(arg), DELTA);
    }

}
