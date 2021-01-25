package test.com.epam.task.first;

import com.epam.task.first.ArrayParser;
import com.epam.task.first.entities.Array;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class ArrayParserTest {

    ArrayParser parser = new ArrayParser();

    @Test
    public void testParseShouldReturnArrayWhenValidStringApplied() {
        String validLine = "123 -5 2 0   9 3";

        Array array = parser.parse(validLine);

        List<Integer> actual = array.getElements();
        Assert.assertArrayEquals(new Integer[] {123, -5, 2, 0, 9, 3}, actual.toArray());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParseShouldThrowExceptionWhenNotValidStringApplied() {
        String invalidLine = "123 -5 2 0 a b 9 3";

        Array array = parser.parse(invalidLine);
    }

    @Test
    public void testParseShouldReturnEmptyArrayWhenEmptyStringApplied() {
        String emptyLine = "";

        Array array = parser.parse(emptyLine);

        Assert.assertArrayEquals(new Integer[]{}, array.getElements().toArray());
    }
}
