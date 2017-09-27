package com.company;

import java.io.*;
import java.util.Scanner;

public class FileReader {
    public String filePath;

    public FileReader(String filePath) {
        this.filePath = filePath;
    }

    public static Scanner readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        return new Scanner(file);
    }

    public String getFilePath() throws IOException {
        return this.filePath;
    }
}
