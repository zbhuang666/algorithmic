package com.zhs.zbhuang.abing;

import java.util.concurrent.Semaphore;

public class H2O {

    public H2O() {
    }

    private Semaphore h = new Semaphore(2);
    private Semaphore o = new Semaphore(2);

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        h.acquire(1);
        releaseHydrogen.run();
        o.release();
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        o.acquire(2);
        releaseOxygen.run();
        h.release(2);
    }

    class ReleaseHydrogen implements Runnable{

        @Override
        public void run() {

        }
    }

    class ReleaseOxygen implements Runnable{

        @Override
        public void run() {

        }
    }
}

