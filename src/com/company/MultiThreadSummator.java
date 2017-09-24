package com.company;

import java.util.Scanner;

public class MultiThreadSummator extends Thread {
    private ResourceStorage storage;
    private Scanner scanner;


    public MultiThreadSummator(ResourceStorage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        try {
            while (scanner.hasNextInt()) {
                storage.addValue(scanner.nextInt());
            }
        } catch (RuntimeException e) {
            if (scanner.hasNext()) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}