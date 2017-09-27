package com.company;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        Summator sumCalculation = new Summator();
        FileReaderTest fileReaderTest = new FileReaderTest();

        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};

        IResourceStorage storage = sumCalculation.getSum(resources);
        System.out.println("Общая сумма : " + storage.getValue());

        if(storage.getValue() != 0){
            storage.getInfoAboutStorage();
        }

        for(int i = 1; i < 7; i++){
            FileReader fileReader = new FileReader(resources[i]);
            try {
                FileReader.readFromFile(resources[i]);
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileReader.getFilePath();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

