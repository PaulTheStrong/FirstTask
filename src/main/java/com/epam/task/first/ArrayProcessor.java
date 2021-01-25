package com.epam.task.first;

import com.epam.task.first.data.DataException;
import com.epam.task.first.data.FileDataReader;
import com.epam.task.first.entities.Array;

import java.util.ArrayList;
import java.util.List;

public class ArrayProcessor {

    private ArrayValidator validator;
    private ArrayParser parser;
    private FileDataReader dataReader;

    public ArrayProcessor(ArrayValidator validator, ArrayParser parser, FileDataReader fileDataReader) {
        this.validator = validator;
        this.parser = parser;
        this.dataReader = fileDataReader;
    }

    public List<Array> process(String filename) {
        try {
            List<Array> resultList = new ArrayList<>();
            List<String> lines = dataReader.readLines(filename);
            for (String line : lines) {
                boolean isValidLine = validator.validate(line);
                if (isValidLine) {
                    Array array = parser.parse(line);
                    resultList.add(array);
                }
            }
            return resultList;
        } catch (DataException e) {
            System.out.println(e.getMessage());
            return null;
        }
    }
}
