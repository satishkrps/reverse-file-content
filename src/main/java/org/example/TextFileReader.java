package org.example;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TextFileReader {

    public void readAndReverseTextFile(String inputFileName, String outputFileName){
        final int RECORD_COUNT = 4000000;
        try (BufferedReader reader =
                     new BufferedReader(new FileReader(inputFileName))) {
            List<String> records = new ArrayList<>(RECORD_COUNT);
            String line;


            while ((line = reader.readLine()) != null)  {
                StringBuilder content = new StringBuilder();
                content.append(line);
                content.append("\n");
                records.add(String.valueOf(content.reverse()));

            }
            ReverseFileWriter.writeBuffered(records, 8192, outputFileName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
