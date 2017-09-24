package com.company;

public class ResourceStorage implements IResourceStorage{
    private int value = 0;

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public synchronized void addValue(int value) {
        if(value < 0 || value % 2 != 0) {
            return;
        }
        this.value += value;
        System.out.println("Промежуточный результат : " + this.value);
    }
}
