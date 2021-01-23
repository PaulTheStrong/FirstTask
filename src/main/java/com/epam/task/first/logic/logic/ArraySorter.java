package com.epam.task.first.logic.logic;

import com.epam.task.first.logic.entities.Array;

import java.util.Collections;
import java.util.List;

public class ArraySorter {

    public Array bubbleSort(Array array) {
        List<Integer> baseElements = array.getElements();

        Array result = new Array();
        List<Integer> resultElements = result.getElements();
        resultElements.addAll(baseElements);

        int size = resultElements.size();
        for(int i = 0; i < size - 1; i++) {
            for (int j = 0; j < size - i - 1; j++) {
                if (resultElements.get(j) > resultElements.get(j + 1)) {
                    Collections.swap(resultElements, j, j + 1);
                }
            }
        }

        return  result;
    }

    public Array selectionSort(Array array) {
        List<Integer> baseElements = array.getElements();

        Array result = new Array();
        List<Integer> resultElements = result.getElements();
        resultElements.addAll(baseElements);

        int size = resultElements.size();
        for(int i = 0; i < size; i++) {
            int minimum = resultElements.get(i);
            int minimumIndex = i;
            for (int j = i; j < size; j++) {
                if (minimum > resultElements.get(j)) {
                    minimumIndex = j;
                    minimum = resultElements.get(j);
                }
            }
            Collections.swap(resultElements, minimumIndex, i);
        }

        return  result;
    }

    private void quickSort(Array array, int leftBound, int rightBound) {
        List<Integer> elements = array.getElements();
        int left = leftBound, right = rightBound;
        int pivot = elements.get(left + (right - left) / 2);
        if (leftBound >= rightBound)
            return;
        while (left <= right) {
            while (elements.get(left) < pivot) {
                left++;
            }

            while (elements.get(right) > pivot) {
                right--;
            }

            if (left <= right) {
                Collections.swap(elements, left, right);
                left++;
                right--;
            }
        }

        if (right > leftBound) {
            quickSort(array, leftBound, right);
        }

        if (left < rightBound) {
            quickSort(array, left, rightBound);
        }
    }

    public Array quickSort(Array array) {
        List<Integer> baseElements = array.getElements();

        Array result = new Array();
        List<Integer> resultElements = result.getElements();
        resultElements.addAll(baseElements);

        quickSort(result, 0, resultElements.size() - 1);

        return  result;
    }

}
