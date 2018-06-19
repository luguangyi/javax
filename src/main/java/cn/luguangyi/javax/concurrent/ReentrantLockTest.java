package cn.luguangyi.javax.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class ReentrantLockTest {
    private final ReentrantLock lock = new ReentrantLock();

    private int n = 0;
    public void increase() {
        lock.lock();
        try {
            n++;
        } finally {
            lock.unlock();
        }
//        n++;

    }

    public int getN() {
        return n;
    }

    public static void main(String[] args) throws InterruptedException {
        ReentrantLockTest reentrantLockTest = new ReentrantLockTest();
        IncreaseRunner increaseRunnerA = new IncreaseRunner(reentrantLockTest);
        IncreaseRunner increaseRunnerB = new IncreaseRunner(reentrantLockTest);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(increaseRunnerB);
        executorService.execute(increaseRunnerA);
        executorService.shutdown();

        while (true) {
            // 所有任务全部执行终止
            if (executorService.isTerminated()) { // 当shutdown()或者shutdownNow()执行了之后才会执行，并返回true。
                System.out.println("结束了！");
                break;
            }
            Thread.sleep(200L);
        }
        System.out.println(reentrantLockTest.getN());
    }
}

class IncreaseRunner implements Runnable {

    private ReentrantLockTest reentrantLockTest;

    public IncreaseRunner(ReentrantLockTest reentrantLockTest) {
        this.reentrantLockTest = reentrantLockTest;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100000; i++) {
            reentrantLockTest.increase();
        }
    }
}
