class BarrierV1 extends Barrier {
    BarrierV1(int t, int rowLength, int colLength) {
        super(t, rowLength, colLength);
        syncModel = "synchronized, wait & notifyAll";
    }

    /**
     * Blocks a thread so it waits on barrier. Uses standard wait method of Object class.
     * @throws InterruptedException
     */
    synchronized void block() throws InterruptedException {
        wait();
    }

    /**
     * Wakes up all the threads reached at barrier. Uses standard notifyAll method of Object class.
     */
    synchronized void broadcastAll() {
        notifyAll();
    }

    /**
     * Provides barrier synchronization.
     * @throws InterruptedException
     */
    synchronized void waitOnBarrier() throws InterruptedException {
        // When a thread enters this synchronized method, it increments the number of threads
        // at barrier then waits for others to reach the barrier.
        curNumThreads++;
        if (curNumThreads == numThreads) {
            // If all the threads reach the barrier, then notify them so that they continue to their task.
            barrierEndOperation();
            broadcastAll();
        }
        else while (curNumThreads < numThreads) {
            block();
        }
    }
}
