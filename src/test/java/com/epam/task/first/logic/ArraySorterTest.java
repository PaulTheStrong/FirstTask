package com.epam.task.first.logic;

import com.epam.task.first.logic.entities.Array;
import com.epam.task.first.logic.logic.ArraySorter;
import org.junit.Assert;
import org.junit.Test;

public class ArraySorterTest {

    private ArraySorter arraySorter = new ArraySorter();

    @Test
    public void testBubbleSortShouldSortArrayWhenNonEmptyArrayApplied() {
        Array array = new Array(5, 9, 7, 0, -4);

        Array sortedArray = arraySorter.bubbleSort(array);

        Assert.assertArrayEquals(new Integer[] {-4, 0, 5, 7, 9}, sortedArray.getElements().toArray());
    }

    @Test
    public void testBubbleSortShouldSortArrayWhenArrayWithSameElementsApplied() {
        Array array = new Array(1, 1, 1);

        Array sortedArray = arraySorter.bubbleSort(array);

        Assert.assertArrayEquals(new Integer[] {1, 1, 1}, sortedArray.getElements().toArray());

    }

    @Test
    public void testSelectionSortShouldSortArrayWhenNonEmptyArrayApplied() {
        Array array = new Array(5, 9, 7, 0, -4);

        Array sortedArray = arraySorter.selectionSort(array);

        Assert.assertArrayEquals(new Integer[] {-4, 0, 5, 7, 9}, sortedArray.getElements().toArray());
    }

    @Test
    public void testSelectionSortShouldSortArrayWhenArrayWithSameElementsApplied() {
        Array array = new Array(1, 1, 1);

        Array sortedArray = arraySorter.selectionSort(array);

        Assert.assertArrayEquals(new Integer[] {1, 1, 1}, sortedArray.getElements().toArray());

    }

    @Test
    public void testQuickSortShouldSortArrayWhenNonEmptyArrayApplied() {
        Array array = new Array(5, 9, 7, 0, -4);

        Array sortedArray = arraySorter.quickSort(array);

        Assert.assertArrayEquals(new Integer[] {-4, 0, 5, 7, 9}, sortedArray.getElements().toArray());
    }

    @Test
    public void testQuickSortShouldSortArrayWhenArrayWithSameElementsApplied() {
        Array array = new Array(1, 1, 1);

        Array sortedArray = arraySorter.quickSort(array);

        Assert.assertArrayEquals(new Integer[] {1, 1, 1}, sortedArray.getElements().toArray());
    }
}
