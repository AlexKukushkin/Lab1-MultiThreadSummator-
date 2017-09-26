package com.company;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Summator implements ISummator {
    private List<Thread> threads;
    private ResourceStorage storage;

    private ResourceStorage getStorage() {
        return this.storage;
    }

    @Override
    public ResourceStorage getSum(String[] resources) {
        this.storage = new ResourceStorage();
        this.threads = new ArrayList<>();

        createThreads(resources);

        for(Thread thread: threads) {
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
                threads.add(thread);
            }
            catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
    private Thread getMultiThreadSummator(String resource) throws IOException {
        return new MultiThreadSummator(getStorage(), FileReader.readFromFile(resource));
    }
}

