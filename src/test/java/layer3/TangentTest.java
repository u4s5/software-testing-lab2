package layer3;

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
import system.expressions.functions.Cosine;
import system.expressions.functions.Tangent;
import system.expressions.functions.basic.Sine;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;

@RunWith(PowerMockRunner.class)
@PowerMockRunnerDelegate(value = Parameterized.class)
@PrepareForTest({Sine.class, Cosine.class})
public class TangentTest {

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

                {"Testing x = 0", 0D, 0D},
                {"Testing x = 0 - delta", -0.001, -DELTA},
                {"Testing x = 0 + delta", 0.001, DELTA},

                {"Testing x = -pi/2", Double.NaN, -Math.PI / 2},
                {"Testing x = -pi/2 - delta", 1000D, -Math.PI / 2 - DELTA},
                {"Testing x = -pi/2 + delta", -1000D, -Math.PI / 2 + DELTA},

                {"Testing x = pi/2", Double.NaN, Math.PI / 2},
                {"Testing x = pi/2 - delta", 1000D, Math.PI / 2 - DELTA},
                {"Testing x = pi/2 + delta", -1000D, Math.PI / 2 + DELTA},

                {"Testing x = -pi/4", -1D, -Math.PI / 4},
                {"Testing x = -pi/3", -1.73205, -Math.PI / 3},

                {"Testing x = pi/5", 0.726543, Math.PI / 5},
                {"Testing x = pi/3", 1.73205, Math.PI / 3}

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


        BDDMockito.given(Sine.calcSin(-Math.PI / 4)).willReturn(-0.707107);
        BDDMockito.given(Sine.calcSin(-Math.PI / 3)).willReturn(-0.866025);

        BDDMockito.given(Sine.calcSin(Math.PI / 5)).willReturn(0.587785);
        BDDMockito.given(Sine.calcSin(Math.PI / 3)).willReturn(0.866025);
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


        BDDMockito.given(Cosine.calcCos(-Math.PI / 4)).willReturn(0.707107);
        BDDMockito.given(Cosine.calcCos(-Math.PI / 3)).willReturn(0.5);

        BDDMockito.given(Cosine.calcCos(Math.PI / 5)).willReturn(0.809017);
        BDDMockito.given(Cosine.calcCos(Math.PI / 3)).willReturn(0.5);
    }

    @Test
    public void test() {
        if (expectedResult.isNaN())
            assertTrue(message, Double.isNaN(Tangent.calcTan(arg)));
        else
            assertEquals(message, expectedResult, Tangent.calcTan(arg), DELTA);
    }

}
