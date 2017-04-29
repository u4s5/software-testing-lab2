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
import system.expressions.functions.Cotangent;
import system.expressions.functions.basic.Sine;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest({Sine.class, Cosine.class})
public class CotangentTest {

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

                {"Testing x = 0", Double.NaN, 0D},
                {"Testing x = 0 - delta", -1000D, -DELTA},
                {"Testing x = 0 + delta", 1000D, DELTA},

                {"Testing x = pi", Double.NaN, Math.PI},
                {"Testing x = pi - delta", -1000D, Math.PI - DELTA},
                {"Testing x = pi + delta", 1000D, Math.PI + DELTA},

                {"Testing x = pi/2", 0D, Math.PI / 2},
                {"Testing x = pi/2 - delta", 0.001, Math.PI / 2 - DELTA},
                {"Testing x = pi/2 + delta", -0.001, Math.PI / 2 + DELTA},

                {"Testing x = pi/4", 1D, Math.PI / 4},
                {"Testing x = pi/3", 0.57735, Math.PI / 3},

                {"Testing x = 9pi/16", -0.198912, 9 * Math.PI / 16},
                {"Testing x = 11pi/16", -0.668179, 11 * Math.PI / 16}

        });
    }

    @Before
    public void mockSine() {
        PowerMockito.mockStatic(Sine.class);

        BDDMockito.given(Sine.calcSin(0D)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(-DELTA)).willReturn(-0.001);
        BDDMockito.given(Sine.calcSin(DELTA)).willReturn(0.001);

        BDDMockito.given(Sine.calcSin(Math.PI)).willReturn(0D);
        BDDMockito.given(Sine.calcSin(Math.PI - DELTA)).willReturn(0.001);
        BDDMockito.given(Sine.calcSin(Math.PI + DELTA)).willReturn(-0.001);

        BDDMockito.given(Sine.calcSin(Math.PI / 2)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(Math.PI / 2 - DELTA)).willReturn(1D);
        BDDMockito.given(Sine.calcSin(Math.PI / 2 + DELTA)).willReturn(1D);


        BDDMockito.given(Sine.calcSin(Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Sine.calcSin(Math.PI / 3)).willReturn(0.866025);

        BDDMockito.given(Sine.calcSin(9 * Math.PI / 16)).willReturn(0.980785);
        BDDMockito.given(Sine.calcSin(11 * Math.PI / 16)).willReturn(0.83147);
    }

    @Before
    public void mockCosine() {
        PowerMockito.mockStatic(Cosine.class);

        BDDMockito.given(Cosine.calcCos(0D)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(-DELTA)).willReturn(1D);
        BDDMockito.given(Cosine.calcCos(DELTA)).willReturn(1D);

        BDDMockito.given(Cosine.calcCos(Math.PI)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(Math.PI - DELTA)).willReturn(-1D);
        BDDMockito.given(Cosine.calcCos(Math.PI + DELTA)).willReturn(-1D);

        BDDMockito.given(Cosine.calcCos(Math.PI / 2)).willReturn(0D);
        BDDMockito.given(Cosine.calcCos(Math.PI / 2 - DELTA)).willReturn(0.001);
        BDDMockito.given(Cosine.calcCos(Math.PI / 2 + DELTA)).willReturn(-0.001);


        BDDMockito.given(Cosine.calcCos(Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Cosine.calcCos(Math.PI / 3)).willReturn(0.5);

        BDDMockito.given(Cosine.calcCos(9 * Math.PI / 16)).willReturn(-0.19509);
        BDDMockito.given(Cosine.calcCos(11 * Math.PI / 16)).willReturn(-0.55557);
    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(Cotangent.calcCot(arg)));
        else
            assertEquals(message, expectedResult, Cotangent.calcCot(arg), DELTA);
    }

}
