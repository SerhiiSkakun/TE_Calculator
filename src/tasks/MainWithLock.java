package tasks;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MainWithLock extends Task1{

    Lock lock = new ReentrantLock();
    Condition condition = lock.newCondition();

    public static void main(String[] args) {
        new MainWithLock().run();
    }

    @Override
    void sentResult(double result) {
        lock.lock();
        total += result;
        finished++;
        condition.signal();
        lock.unlock();
    }

    private void run() {
        long startTime = System.currentTimeMillis();
        int nTreads = 4;
        startThreads(nTreads);
        lock.lock();
        try {
            while (finished < nTreads){
                condition.await();
            }
        }
        catch (InterruptedException ignored) {}
        finally {
            lock.unlock();
        }
        long finishTime = System.currentTimeMillis();

        System.out.println("total = " + total);
        System.out.println(finishTime - startTime);


    }
}
