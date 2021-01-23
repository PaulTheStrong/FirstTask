package com.epam.task.first.logic.view;

import com.epam.task.first.logic.entities.Array;

public class ConsoleArrayPrinter implements ArrayPrinter {
    public void print(final Array array) {
        for (Integer element : array.getElements()) {
            System.out.println(element);
        }
    }
}
