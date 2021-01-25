package test.com.epam.task.first.data;

import com.epam.task.first.data.DataException;
import com.epam.task.first.data.FileDataReader;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class FileDataReaderTest {

    FileDataReader reader = new FileDataReader();
    private static final String BASE_RESOURCE_DIRECTORY = "./src/test/resources/dataTest/";

    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenFileDoesntExist() throws DataException {
        String filename = BASE_RESOURCE_DIRECTORY + "doesntExist.txt";

        reader.readLines(filename);
    }

    @Test
    public void testReadLinesShouldReturnListOfLineWhenFileExists() throws DataException {
        String filename =  BASE_RESOURCE_DIRECTORY + "testData.txt";
        String[] expected = new String[] {"123 345", "vcxs", "aaaa aaa"};

        List<String> actual = reader.readLines(filename);

        Assert.assertArrayEquals(expected, actual.toArray());
    }

    @Test(expected = DataException.class)
    public void testReadLinesShouldThrowDataExceptionWhenEmptyFileApplied() throws DataException {
        String filename = BASE_RESOURCE_DIRECTORY + "empty.txt";

        reader.readLines(filename);
    }

}
