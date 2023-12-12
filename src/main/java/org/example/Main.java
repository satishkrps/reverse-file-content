package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

          final int RECORD_COUNT = 4000000;
          try (BufferedReader reader =
                       new BufferedReader(new FileReader("src/main/resources/test.txt"))) {
              List<String> records = new ArrayList<>(RECORD_COUNT);
              String line;


            while ((line = reader.readLine()) != null)  {
                StringBuilder content = new StringBuilder();
                    content.append(line);
                    content.append("\n");
                    records.add(String.valueOf(content.reverse()));

            }
              ReverseFileWriter.writeBuffered(records, 8192);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}