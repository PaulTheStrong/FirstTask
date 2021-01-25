package com.epam.task.first;

import com.epam.task.first.entities.Array;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.ArrayList;
import java.util.List;

public class ArrayParser {

    public Array parse(String data) {
        List<Integer> values = new ArrayList<>();

        StringBuilder currentNumber = new StringBuilder();
        for (int i = 0; i < data.length(); i++) {
            char currentChar = data.charAt(i);
            if (currentChar != ' ') {
                currentNumber.append(currentChar);
            } else {
                if (currentNumber.length() != 0) {
                    int number = new Integer(currentNumber.toString());
                    values.add(number);
                }
                currentNumber = new StringBuilder();
            }
        }
        if (currentNumber.length() != 0) {
            int number = new Integer(currentNumber.toString());
            values.add(number);
        }
        return new Array(values);
    }

}
