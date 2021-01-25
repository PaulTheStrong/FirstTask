package com.epam.task.first.data;

import javax.xml.crypto.Data;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FileDataReader {

    public List<String> readLines(String filename) throws DataException {
        try {
            BufferedInputStream inputStream = new BufferedInputStream(new FileInputStream(filename));
            int fileSize = 0;
            List<String> lines = new ArrayList<>();
            StringBuilder currentLine = new StringBuilder();
            int currentChar;
            while ((currentChar = inputStream.read()) != -1) {
                fileSize += 1;
                if (currentChar != '\n') {
                    if (currentChar != '\r') {
                        currentLine.append((char) currentChar);
                    }
                } else {
                    lines.add(currentLine.toString());
                    currentLine = new StringBuilder();
                }
            }
            if (fileSize == 0) {
                throw new DataException("File is empty!");
            }
            lines.add(currentLine.toString());
            return lines;
        } catch (FileNotFoundException e) {
            throw new DataException("File not found! " + e.getMessage(), e);
        } catch (IOException e) {
            throw new DataException(e.getMessage(), e);
        }
    }

}
