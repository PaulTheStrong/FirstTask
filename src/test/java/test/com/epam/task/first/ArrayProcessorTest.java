package test.com.epam.task.first;

import com.epam.task.first.ArrayParser;
import com.epam.task.first.ArrayProcessor;
import com.epam.task.first.ArrayValidator;
import com.epam.task.first.data.DataException;
import com.epam.task.first.data.FileDataReader;
import com.epam.task.first.entities.Array;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

public class ArrayProcessorTest {

    private static final List<String> STRING_TEST_DATA = Arrays.asList("1 2 3", "a b 3z", "1 -3      2");

    @Test
    public void testProcessShouldReturnListOfArraysWhenAllLinesAreCorrect() throws DataException {
        FileDataReader reader = Mockito.mock(FileDataReader.class);
        when(reader.readLines(anyString())).thenReturn(STRING_TEST_DATA);

        ArrayValidator validator = Mockito.mock(ArrayValidator.class);
        when(validator.validate(STRING_TEST_DATA.get(0))).thenReturn(true);
        when(validator.validate(STRING_TEST_DATA.get(1))).thenReturn(false);
        when(validator.validate(STRING_TEST_DATA.get(2))).thenReturn(true);

        ArrayParser parser = Mockito.mock(ArrayParser.class);
        when(parser.parse(STRING_TEST_DATA.get(0))).thenReturn(new Array(1, 2, 3));
        when(parser.parse(STRING_TEST_DATA.get(2))).thenReturn(new Array(1, -3, 2));

        ArrayProcessor processor = new ArrayProcessor(validator, parser, reader);

        List<Array> actual = processor.process("filename");

        Assert.assertEquals(new Array(1, 2, 3).toString() + new Array(1, -3, 2).toString(), actual.get(0).toString() + actual.get(1).toString());
    }

}
