package com.epam.task.first.logic;

import com.epam.task.first.logic.entities.Array;
import com.epam.task.first.logic.logic.ArrayLogic;
import org.junit.Assert;
import org.junit.Test;

public class ArrayLogicTest {

    private ArrayLogic arrayLogic = new ArrayLogic();
    private final double DELTA = 0.001;

    @Test
    public void testFindMaxShouldFindMaxWhenPositiveNumbersApplied() {
        //given
        Array array = new Array(1, 4, 3);

        //when
        int actual = arrayLogic.findMax(array);

        //then
        Assert.assertEquals(4, actual);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenNegativeNumbersApplied() {
        //given
        Array array = new Array(-1, -4, -3);

        //when
        int actual = arrayLogic.findMax(array);

        //then
        Assert.assertEquals(-1, actual);
    }

    @Test
    public void testFindMaxShouldFindMaxWhenTheSameNumbersApplied() {
        //given
        Array array = new Array(0, 0, 0, 0);

        //when
        int actual = arrayLogic.findMax(array);

        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testFindMaxShouldThrowExceptionWhenEmptyArrayApplied() {
        //given
        Array array = new Array();
        String expectedMessage = "Array mustn't be empty!";

        //when
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            arrayLogic.findMax(array);
        });
        String actualMessage = exception.getMessage();

        //then
        Assert.assertEquals(expectedMessage, actualMessage);
    }

    @Test
    public void testFindMinShouldFindMinWhenPositiveNumbersApplied() {
        //given
        Array array = new Array(1, 4, 3);

        //when
        int actual = arrayLogic.findMin(array);

        //then
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testFindMinShouldFindMinWhenNegativeNumbersApplied() {
        //given
        Array array = new Array(-1, -4, -3);

        //when
        int actual = arrayLogic.findMin(array);

        //then
        Assert.assertEquals(-4, actual);
    }

    @Test
    public void testFindMinShouldFindMinWhenTheSameNumbersApplied() {
        //given
        Array array = new Array(0, 0, 0, 0);

        //when
        int actual = arrayLogic.findMin(array);

        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testFindMinShouldThrowExceptionWhenEmptyArrayApplied() {
        //given
        Array array = new Array();
        String expectedMessage = "Array mustn't be empty!";

        //when
        Exception exception = Assert.assertThrows(IllegalArgumentException.class, () -> {
            arrayLogic.findMin(array);
        });
        String actualMessage = exception.getMessage();

        //then
        Assert.assertEquals(expectedMessage, actualMessage);
    }


    @Test
    public void testCountAvgShouldFindAvgWhenPositiveNumbersApplied() {
        //given
        Array array = new Array(1, 5, 10, 2, 3);

        //when
        double actual = arrayLogic.countAvg(array);

        //then
        Assert.assertEquals(21/5., actual, DELTA);
    }

    @Test
    public void testCountAvgShouldFindAvgWhenPositiveAndNegativeNumbersApplied() {
        //given
        Array array = new Array(1, -5, 10, 2, -3);

        //when
        double actual = arrayLogic.countAvg(array);

        //then
        Assert.assertEquals(5. / 5, actual, DELTA);
    }

    @Test
    public void testCountAvgShouldReturnZeroWhenEmptyArrayApplied() {
        //given
        Array array = new Array();

        //when
        double actual = arrayLogic.countAvg(array);

        //then
        Assert.assertEquals(0, actual, DELTA);
    }

    @Test
    public void testCountPositiveShouldReturnPositiveCountWhenPositiveNumbersApplied() {
        //given
        Array array = new Array(5, 2, 3, 1);

        //when
        int actual = arrayLogic.countPositiveNumbers(array);

        //then
        Assert.assertEquals(4, actual);
    }



    @Test
    public void testCountPositiveShouldReturnPositiveCountWhenBothPositiveAndNegativeNumbersApplied() {
        //given
        Array array = new Array(-5, 2, 3, -1);

        //when
        int actual = arrayLogic.countPositiveNumbers(array);

        //then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCountPositiveShouldReturnPositiveCountWhenZeroesApplied() {
        //given
        Array array = new Array(0, 0, 0, 0, 1);

        //when
        int actual = arrayLogic.countPositiveNumbers(array);

        //then
        Assert.assertEquals(1, actual);
    }

    @Test
    public void testCountPositiveShouldReturnZeroWhenEmptyArrayApplied() {
        //given
        Array array = new Array();

        //when
        int actual = arrayLogic.countPositiveNumbers(array);

        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCountNegativeShouldReturnNegativeCountWhenPositiveNumbersApplied() {
        //given
        Array array = new Array(5, 2, 3, 1);

        //when
        int actual = arrayLogic.countNegativeNumbers(array);

        //then
        Assert.assertEquals(0, actual);
    }



    @Test
    public void testCountNegativeShouldReturnNegativeCountWhenBothPositiveAndNegativeNumbersApplied() {
        //given
        Array array = new Array(-5, -2, 3, -1);

        //when
        int actual = arrayLogic.countNegativeNumbers(array);

        //then
        Assert.assertEquals(3, actual);
    }

    @Test
    public void testCountNegativeShouldReturnNegativeCountWhenZeroesApplied() {
        //given
        Array array = new Array(0, 0, 0, -2, -1);

        //when
        int actual = arrayLogic.countNegativeNumbers(array);

        //then
        Assert.assertEquals(2, actual);
    }

    @Test
    public void testCountNegativeShouldReturnZeroWhenEmptyArrayApplied() {
        //given
        Array array = new Array();

        //when
        int actual = arrayLogic.countNegativeNumbers(array);

        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCountSumShouldReturnZeroWhenEmptyArrayApplied() {
        //given
        Array array = new Array();

        //when
        int actual = arrayLogic.countSum(array);

        //then
        Assert.assertEquals(0, actual);
    }

    @Test
    public void testCountSumShouldReturnSumWhenNonEmptyArrayApplied() {
        Array array = new Array(5, -1, 0, 2, -7, 8);

        int actual = arrayLogic.countSum(array);

        Assert.assertEquals(7, actual);
    }

}
