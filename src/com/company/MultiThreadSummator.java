package com.company;

import java.util.Scanner;

public class MultiThreadSummator extends Thread {
    private ResourceStorage storage;
    private Scanner scanner;
    public static volatile boolean stopper = false;

    public MultiThreadSummator(ResourceStorage storage, Scanner scanner) {
        this.storage = storage;
        this.scanner = scanner;
    }

    @Override
    public void run() {
        try {
            while (scanner.hasNext() && !stopper) {
                if(scanner.hasNextInt()){
                    storage.addValue(scanner.nextInt());
                }else{
                    stopper = true;
                    System.out.println("Все потоки остановлены");
                }
            }
        } catch (RuntimeException e) {
            if (scanner.hasNext()) {
                e.printStackTrace();
            }
        }
        scanner.close();
    }
}