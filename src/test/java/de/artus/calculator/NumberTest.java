package de.artus.calculator;

import de.artus.calculator.objects.Number;
import org.junit.Assert;
import org.junit.Test;

public class NumberTest {

    @Test
    public void getValueTest() {
        double a = 10d;
        double b = new Number(10d).getRealValue();
        Assert.assertEquals(a, b, 0.000001d);
    }

}
