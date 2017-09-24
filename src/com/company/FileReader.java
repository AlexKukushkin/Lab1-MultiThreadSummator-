package com.company;

import java.io.*;
import java.util.Scanner;

public class FileReader {
    static Scanner readFromFile(String filePath) throws IOException {
        File file = new File(filePath);
        return new Scanner(file);
    }
}
