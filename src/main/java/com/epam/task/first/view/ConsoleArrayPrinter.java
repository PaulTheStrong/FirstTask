package com.epam.task.first.view;

import com.epam.task.first.entities.Array;

public class ConsoleArrayPrinter implements ArrayPrinter {
    public void print(final Array array) {
        for (Integer element : array.getElements()) {
            System.out.println(element);
        }
    }
}
