abstract class Barrier {
    /**
     * Number of threads that created.
     */
    int numThreads;

    /**
     * Number of threads that waits on barrier currently.
     */
    int curNumThreads;

    /**
     * This is used to identify different synchronization models.
     */
    String syncModel;
    Complex[][] sum;
    Complex[][] dft;

    /**
     *
     * @return dft of A+B square matrices
     */
    Complex[][] getResult() {
        return dft;
    }

    /**
     * Constructor that creates sum and dft Complex arrays.
     *
     * @param t number of threads
     * @param rowLength matrix row length
     * @param colLength matrix column length
     */
    Barrier(int t, int rowLength, int colLength) {
        curNumThreads = 0;
        numThreads = t;
        sum = UtilsMatrix.createComplexMatrix(rowLength, colLength);
        dft = UtilsMatrix.createComplexMatrix(rowLength, colLength);
    }

    /**
     * T
     * @throws InterruptedException
     */
    abstract void waitOnBarrier() throws InterruptedException;

    /**
     * Blocks a thread so it waits on barrier.
     * @throws InterruptedException
     */
    abstract void block() throws InterruptedException;

    /**
     * Wakes up all the threads reached at barrier.
     */
    abstract void broadcastAll();

    /**
     * Last operation to do when barriers is reached.
     * If matrix size is less than 16 it is printed on terminal.
     */
    void barrierEndOperation() {
        if (sum.length <= 16 && sum[0].length <= 16) {
            UtilsMatrix.print2DComplexMatrix(sum);
        }
        System.out.println("Summation of A and B matrices is completed.");
        System.out.println("Calculating DFT of A+B...");
    }
}
