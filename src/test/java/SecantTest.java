import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.mockito.BDDMockito;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.powermock.modules.junit4.PowerMockRunnerDelegate;
import system.expressions.functions.Cosine;
import system.expressions.functions.Secant;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest(Cosine.class)
public class SecantTest {

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

                {"Testing x = -pi/2", Double.NaN, -Math.PI / 2},
                {"Testing x = -pi/2 - delta", -1000D, -Math.PI / 2 - DELTA},
                {"Testing x = -pi/2 + delta", 1000D, -Math.PI / 2 + DELTA},

                {"Testing x = 0", 1D, 0D},
                {"Testing x = 0 - delta", 1D, -DELTA},
                {"Testing x = 0 + delta", 1D, DELTA},

                {"Testing x = pi/2", Double.NaN, Math.PI / 2},
                {"Testing x = pi/2 - delta", 1000D, Math.PI / 2 - DELTA},
                {"Testing x = pi/2 + delta", -1000D, Math.PI / 2 + DELTA},

                {"Testing x = pi", -1D, Math.PI},
                {"Testing x = pi - delta", -1D, Math.PI - DELTA},
                {"Testing x = pi + delta", -1D, Math.PI + DELTA},

                {"Testing x = 3pi/2", Double.NaN, 3 * Math.PI / 2},
                {"Testing x = 3pi/2 - delta", -1000D, 3 * Math.PI / 2 - DELTA},
                {"Testing x = 3pi/2 + delta", 1000D, 3 * Math.PI / 2 + DELTA},


                {"Testing x = -pi/5", 1.23607, -Math.PI / 5},
                {"Testing x = -pi/7", 1.10992, -Math.PI / 7},

                {"Testing x = pi/4", 1.41421, Math.PI / 4},
                {"Testing x = pi/6", 1.1547, Math.PI / 6},

                {"Testing x = 3pi/4", -1.41421, 3 * Math.PI / 4},
                {"Testing x = 6pi/7", -1.10992, 6 * Math.PI / 7},

                {"Testing x = 11pi/10", -1.05146, 11 * Math.PI / 10},
                {"Testing x = 14pi/10", -3.23607, 14 * Math.PI / 10}

        });
    }

    @Before
    public void mockCosine() {
        PowerMockito.mockStatic(Cosine.class);

        BDDMockito.given(Cosine.calcCos(-Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 2 - DELTA)).willReturn(-0.001);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 2 + DELTA)).willReturn(0.001);

        BDDMockito.given(Cosine.calcCos(0D)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(-DELTA)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(DELTA)).willReturn(1D);

        BDDMockito.given(Cosine.calcCos(Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(Math.PI / 2 - DELTA)).willReturn(0.001);
        BDDMockito.given(Cosine.calcCos(Math.PI / 2 + DELTA)).willReturn(-0.001);

        BDDMockito.given(Cosine.calcCos(Math.PI)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(Math.PI - DELTA)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(Math.PI + DELTA)).willReturn(-1D);

        BDDMockito.given(Cosine.calcCos(3 * Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(3 * Math.PI / 2 - DELTA)).willReturn(-0.001);
        BDDMockito.given(Cosine.calcCos(3 * Math.PI / 2 + DELTA)).willReturn(0.001);


        BDDMockito.given(Cosine.calcCos(-Math.PI / 5)).willReturn(0.809017);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 7)).willReturn(0.900969);

        BDDMockito.given(Cosine.calcCos(Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Cosine.calcCos(Math.PI / 6)).willReturn(0.866025);

        BDDMockito.given(Cosine.calcCos(3 * Math.PI / 4)).willReturn(-0.707107);
        BDDMockito.given(Cosine.calcCos(6 * Math.PI / 7)).willReturn(-0.900969);

        BDDMockito.given(Cosine.calcCos(11 * Math.PI / 10)).willReturn(-0.951057);
        BDDMockito.given(Cosine.calcCos(14 * Math.PI / 10)).willReturn(-0.309017);

    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(Secant.calcSec(arg)));
        else
            assertEquals(message, expectedResult, Secant.calcSec(arg), DELTA);
    }

}
