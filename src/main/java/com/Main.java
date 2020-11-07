package com;

import au.com.bytecode.opencsv.CSVParser;
import au.com.bytecode.opencsv.CSVReader;

import java.io.*;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    private final static String CSV_FILE = "foreign_names.csv";

    public static void main(String args[]) {
        try (InputStream in = Main.class.getClassLoader().getResourceAsStream(CSV_FILE);
             au.com.bytecode.opencsv.CSVReader reader = in == null ? null: new au.com.bytecode.opencsv.CSVReader(new InputStreamReader(in), ';')) {
            if (reader == null) {
                try {
                    throw new FileNotFoundException(CSV_FILE);
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }

            List<String[]> allRows = reader.readAll();
            for(String[] row : allRows){
                System.out.println(Arrays.toString(row));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
