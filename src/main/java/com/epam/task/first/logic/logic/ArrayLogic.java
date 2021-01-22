package com.epam.task.first.logic.logic;

import com.epam.task.first.logic.entities.Array;

import java.util.List;
import java.util.function.Predicate;

public class ArrayLogic {

    public int findMax(Array array) {
        List<Integer> elements = array.getElements();
        int max = elements.get(0);
        for (Integer element : elements) {
            max = max < element ? element : max;
        }
        return max;
    }

    public int findMin(Array array) {
        List<Integer> elements = array.getElements();
        int min = elements.get(0);
        for (Integer element : elements) {
            min = min > element ? element : min;
        }

        return min;
    }

    public double countAvg(Array array) {
        double avg = 0;
        List<Integer> elements = array.getElements();
        int size = elements.size();
        for (Integer element : elements) {
            avg += (double)element / size;
        }
        return avg;
    }

    public int countPositiveNumbers(Array array) {
        int positiveCount = 0;
        for (Integer element : array.getElements()) {
            if (element > 0) {
                positiveCount++;
            }
        }
        return positiveCount;
    }

    public int countNegativeNumbers(Array array) {
        int negativeCount = 0;
        for (Integer element : array.getElements()) {
            if (element < 0) {
                negativeCount++;
            }
        }
        return negativeCount;
    }

    public int countSum(Array array) {
        int sum = 0;
        for (Integer element : array.getElements()) {
            sum += element;
        }
        return sum;
    }

    public void changeArrayElementsByCondition(Array array, Predicate<Integer> predicate, Integer newValue) {
        List<Integer> elements = array.getElements();
        for (int i = 0; i < elements.size(); i++) {
            boolean test = predicate.test(elements.get(i));
            if (test) {
                elements.set(i, newValue);
            }
        }
    }

}
