package com.company;

public class Main {
    public static void main(String[] args) {
        Summator sumCalculation = new Summator();
        String[] resources = {"1.txt", "2.txt", "3.txt", "4.txt", "5.txt", "6.txt"};
        ResourceStorage storage;
        storage = sumCalculation.getSum(resources);
        System.out.println("Общая сумма : " + storage.getValue());
    }
}

