import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class BarrierV2 extends Barrier {
    private final Lock lock = new ReentrantLock();
    private final Condition barrierReached = lock.newCondition();

    BarrierV2(int t, int rowLength, int colLength) {
        super(t, rowLength, colLength);
        syncModel = "reentrant lock & condition";
    }

    /**
     * Blocks a thread so it waits on barrier. Uses await method of ReentrantLock.
     * @throws InterruptedException
     */
    void block() throws InterruptedException {
        barrierReached.await();
    }

    /**
     * Wakes up all the threads reached at barrier. Uses standard notifyAll method of Object class.
     */
    void broadcastAll() {
        barrierReached.signalAll();
    }

    /**
     * Provides barrier synchronization.
     * @throws InterruptedException
     */
    void waitOnBarrier() throws InterruptedException {
        // When a thread enters this method, it gets lock first.
        // Thus, we ensure that only single thread entered this area at a given point.
        // After it's job finished here, it gives lock back so that other threads can enter.
        // Remaining operations are same with BarrierV1.
        lock.lock();
        try {
            curNumThreads++;
            if (curNumThreads == numThreads) {
                barrierEndOperation();
                broadcastAll();
            }
            else while (curNumThreads < numThreads) {
                block();
            }
        } finally {
            lock.unlock();
        }
    }
}
