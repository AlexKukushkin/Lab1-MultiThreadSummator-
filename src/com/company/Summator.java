package com.company;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Summator implements ISummator {
    private List<Thread> threads;
    private ResourceStorage storage;
    private ResourceStorage getStorage() {
        return this.storage;
    }


    private List<Thread> getThreads() {
        return threads;
    }
    private void setThreads(List<Thread> threads) {
        this.threads = threads;
    }

    private void setStorage(ResourceStorage storage) {
        this.storage = storage;
    }

    @Override
    public ResourceStorage getSum(String[] resources) {
        this.setStorage(new ResourceStorage());
        this.setThreads(new LinkedList<Thread>());

        createThreads(resources);

        for(Thread thread: getThreads()) {
            try {
                thread.join();
            } catch (InterruptedException e) {
               e.printStackTrace();
            }
        }
        return getStorage();
    }

    private void createThreads(String[] resources) {
        for(String resource: resources) {
            try {
                Thread thread = getMultiThreadSummator(resource);
                thread.start();
                getThreads().add(thread);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private Thread getMultiThreadSummator(String resource) throws IOException {
        return  new MultiThreadSummator(getStorage(), FileReader.readFromFile(resource));
    }
}

