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

        TextFileReader textFileReader = new TextFileReader();
        textFileReader.readAndReverseTextFile("src/main/resources/Input.txt", "src/main/resources/output.txt");

    }



}