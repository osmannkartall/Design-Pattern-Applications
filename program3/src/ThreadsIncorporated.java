class ThreadsIncorporated {
    /**
     * Threads are communicates over the same barrier object. The same barrier object is given threads
     * with it's constructor.
     */
    Barrier barrier;
    static class ParallelDFT implements Runnable {
        private Thread worker;
        /**
         * This is used for interrupting thread to finish it's job and exit it's run method.
         */
        boolean finished = false;

        private Barrier barrier;
        private Complex[][] A;
        private Complex[][] B;
        private int rowStart;
        private int rowLength;
        private int colStart;
        private int colLength;

        /**
         *
         * @param barrier barrier object
         * @param A matrix A
         * @param B matrix B
         * @param rowStart start index of rows assigned to this thread
         * @param rowLength part of the rows assigned to this thread
         * @param colStart start index of columns assigned to this thread
         * @param colLength part of the columns assigned to this thread
         */
        ParallelDFT(Barrier barrier, Complex[][] A, Complex[][] B, int rowStart, int rowLength, int colStart, int colLength) {
            worker = new Thread(this);
            this.barrier = barrier;
            this.A = A;
            this.B = B;
            this.rowStart = rowStart;
            this.rowLength = rowLength;
            this.colStart = colStart;
            this.colLength = colLength;
        }

        /**
         * Thread Task
         * Sum of the A and B matrices calculated by using a barrier object.
         * After that, threads calculates dft of sum(A+B) without waiting for each other.
         */
        public void run() {
            try {
                for (int i = 0; i < rowLength; i++) {
                    for (int j = 0; j < colLength; j++) {
                        barrier.sum[i + rowStart][j + colStart] = Complex.add(A[i + rowStart][j + colStart], B[i + rowStart][j + colStart]);
                    }
                }
                System.out.println(Thread.currentThread().getName());
            /*System.out.println("row: " + Integer.toString(rowStart) + ", " + Integer.toString(rowStart + rowLength - 1));
            System.out.println("col: " + Integer.toString(colStart) + ", " + Integer.toString(colStart + colLength - 1));*/

                // Wait for threads to terminate the summation of A+B.
                barrier.waitOnBarrier();
                // Calculate the DFT of A+B in parallel without barrier.
                twoDimensionDft();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            if (finished)
                System.out.println("Thread interrupted.");
        }

        void start() {
            worker.start();
        }

        void join() throws InterruptedException {
            worker.join();
        }

        /**
         * Calculates two dimensional dft of matrix part assigned to worker.
         */
        private void twoDimensionDft() {
            double M = barrier.sum.length;
            double N = barrier.sum[0].length;

            // rowLength x colLength gives the portion assigned to the thread.
            // rowStart and colStart provide progress on the portion assigned to the thread.
            for (int k = 0; k < rowLength; k++) {
                for (int l = 0; l < colLength; l++) {
                    double sumReal = 0;
                    double sumImag = 0;
                    for (int m = 0; m < M; m++) {
                        for (int n = 0; n < N; n++) {
                            if(finished)
                                return;
                            double angle = 2 * Math.PI * (m * (k+rowStart) / M + (n+colStart) * l / N);
                            sumReal +=  barrier.sum[m][n].real * Math.cos(angle) + barrier.sum[m][n].imag * Math.sin(angle);
                            sumImag += -barrier.sum[m][n].real * Math.sin(angle) + barrier.sum[m][n].imag * Math.cos(angle);
                        }
                    }
                    // The outputs assigned to the thread are calculated.
                    barrier.dft[k+rowStart][l].real =  (1 / Math.sqrt(M * N)) * sumReal;
                    barrier.dft[k+rowStart][l].imag =  (1 / Math.sqrt(M * N)) * sumImag;
                }
            }
        }

    }
}
