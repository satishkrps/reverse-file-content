import org.example.TextFileReader;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.InvalidPathException;

import static org.junit.Assert.assertEquals;

public class TextFileReaderTest {


    File file1, file2;

    /* This directory and the files created in it will be deleted after
     * tests are run, even in the event of failures or exceptions.
     */
    @Rule
    public TemporaryFolder testFolder = new TemporaryFolder();

    /* executed before every test: create two temporary files */
   @Before
    public void setUp() throws IOException {
       try {
           testFolder.newFolder("folder");
           file1 = testFolder.newFile("input.txt");
           file2 = testFolder.newFile("output.txt");

       } catch (InvalidPathException ipe) {
           System.err.println(
                   "error creating temporary test file in " +
                           this.getClass().getSimpleName());
       }

       FileWriter myWriter = new FileWriter(file1);
       myWriter.write("ABC");
       myWriter.close();
   }

    @Test
    public void testFileContentReversal() throws IOException {

        TextFileReader textFileReader = new TextFileReader();
        textFileReader.readAndReverseTextFile(file1.getPath(), file2.getPath());
        FileReader fileReader = new FileReader(file2);
        int i;
        // Using read method
        StringBuilder output = new StringBuilder();
        while ((i = fileReader.read()) != -1) {
            System.out.print((char)i);
            output.append((char)i);
        }
        System.out.println();
        file1.delete();
        file2.delete();
        assertEquals("Comparing the file 2 content after processing ", "CBA", output.toString());


    }

}
