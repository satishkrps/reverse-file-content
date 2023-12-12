package org.example;

import java.io.*;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class ReverseFileWriter {
    public static void writeBuffered(List<String> records, int bufSize) throws IOException {
        Path path = Paths.get("src/main/resources/test1.txt");
        try {
            FileWriter writer = new FileWriter(path.toFile());
            BufferedWriter bufferedWriter = new BufferedWriter(writer, bufSize);

            System.out.print("Writing buffered (buffer size: " + bufSize + ")... ");
            write(records, bufferedWriter);
        } finally {
            // comment this out if you want to inspect the files afterward
            //file.delete();
        }
    }

    private static void write(List<String> records, Writer writer) throws IOException {
        long start = System.currentTimeMillis();
        for (int i =0; i<records.size(); i++) {
            if(i==0 && records.get(0).substring(0, 1).equals("\n")){
                //skip first \n
                // record.replaceFirst("\n", "");
                writer.write(records.get(i).substring(1, records.get(i).length()));

            }
            else {
                writer.write(records.get(i));
            }
        }
        // writer.flush(); // close() should take care of this
        writer.close();
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000f + " seconds");
    }
}

