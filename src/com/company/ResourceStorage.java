package com.company;

public class ResourceStorage implements IResourceStorage{
    private volatile int value = 0;
    private boolean storageFull = false;


    @Override
    public int getValue() {
        return value;
    }

    @Override
    public boolean getInfoAboutStorage(){
        return storageFull = true;
    }

    @Override
    public synchronized void addValue(int value) {
        if(value < 0 || value % 2 != 0) {
            return;
        }
        if(MultiThreadSummator.stopper){
            return;
        }
        this.value += value;
        System.out.println("Промежуточный результат : " + this.value);
    }
}
