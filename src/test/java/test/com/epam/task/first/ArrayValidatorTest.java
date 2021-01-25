package test.com.epam.task.first;

import com.epam.task.first.ArrayValidator;
import org.junit.Assert;
import org.junit.Test;

public class ArrayValidatorTest {

    public final ArrayValidator validator = new ArrayValidator();

    @Test
    public void testValidateShouldReturnTrueWhenStringWithPositiveNumbersApplied() {
        String testLine = "123 2 50";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenStringWithNegativeNumbersApplied() {
        String testLine = "-123 -2 -50 -0";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenStringWithNegativeAndPositiveNumbersApplied() {
        String testLine = "-123 -2 50 -0 10 2";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenStringWithNonDigitsApplied() {
        String testLine = "-123a -2 a 50s -0 10 2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }


    @Test
    public void testValidateShouldReturnFalseWhenStringWithNoSpacesBetweenNegativeNumbersApplied() {
        String testLine = "-123 -2 50-0 10 -2";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }

    @Test
    public void testValidateShouldReturnTrueWhenNumbersAreSeparatedWithMoreThanOneSpaceApplied() {
        String testLine = "-123       -2 50      -0 10 -2";

        boolean actual = validator.validate(testLine);

        Assert.assertTrue(actual);
    }

    @Test
    public void testValidateShouldReturnFalseWhenEmptyStringApplied() {
        String testLine = "";

        boolean actual = validator.validate(testLine);

        Assert.assertFalse(actual);
    }
}
