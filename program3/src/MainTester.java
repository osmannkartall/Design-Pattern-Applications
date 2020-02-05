import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainTester {
    public static void main(String[] args) throws InterruptedException {
        /*BestDSEver bestDSEver = new BestDSEver();
        BestDSEverAdapter bestDSEverAdapter = new BestDSEverAdapter(bestDSEver);
        List<Thread> bestDSEverAdapterThreads = new ArrayList<>();
        int numBestDSEverAdapterThreads = 4;
        for (int i = 0; i < numBestDSEverAdapterThreads; i++)
        {
            bestDSEverAdapterThreads.add(new Thread(new BestDSEverAdapterThread(bestDSEverAdapter)));
            bestDSEverAdapterThreads.get(bestDSEverAdapterThreads.size()-1).start();
        }

        for (int i = 0; i < numBestDSEverAdapterThreads; i++)
            bestDSEverAdapterThreads.get(i).join();

        System.out.println("Threads inserted these items: ");
        for (int i = 0; i < bestDSEver.getObjects().size(); i++) {
            System.out.print(bestDSEverAdapter.take(i) + ", ");
        }*/

        int rowSize = 8;
        int colSize = 8;

        Complex[][] A = UtilsMatrix.createComplexMatrix(rowSize, colSize);
        Complex[][] B = UtilsMatrix.createComplexMatrix(rowSize, colSize);

        A[1][2].real = 70;
        A[1][3].real = 80;
        A[1][4].real = 90;
        A[2][2].real = 90;
        A[2][3].real = 100;
        A[2][4].real = 110;
        A[3][2].real = 110;
        A[3][3].real = 120;
        A[3][4].real = 130;
        A[4][2].real = 130;
        A[4][3].real = 140;
        A[4][4].real = 150;

        System.out.print("Enter number of threads: ");
        Scanner in = new Scanner(System.in);
        int numThreads = in.nextInt();
        while (numThreads < 1 || numThreads > rowSize) {
            if (numThreads > rowSize) {
                System.out.print("Can't divide a row that is size of " + rowSize + " into " + numThreads + " parts.");
            } else {
                System.out.print("You entered a non-positive number for thread count.");
            }
            System.out.print(" Please enter a proper number: ");
            numThreads = in.nextInt();
        }
        int numParts = numThreads;
        List<Thread> threads = new ArrayList<>();
        int rowPartSize;
        int curRowPartSize;
        int lastRowPartSize;

        ThreadsIncorporated threadsIncorporated = new ThreadsIncorporated();
        threadsIncorporated.barrier = new BarrierV2(numThreads, rowSize, colSize);
        rowPartSize = rowSize / numParts;
        curRowPartSize = rowPartSize;
        for (int i = 0; i < numParts; i++) {
            if (i == numParts - 1) {
                 lastRowPartSize = rowPartSize + rowSize % numParts;
                 if (lastRowPartSize != curRowPartSize) {
                     curRowPartSize = lastRowPartSize;
                 }
            }
            threads.add(new Thread(new ThreadsIncorporated.ParallelDFT(threadsIncorporated.barrier,  A, B,
                    rowPartSize * i, curRowPartSize,
                    0, colSize)));
            threads.get(threads.size()-1).start();
        }

        // Wait for threads to terminate after they calculate dft of A+B.
        for (int i = 0; i < numThreads; i++)
            threads.get(i).join();
        System.out.println("Calculation of DFT of A+B is completed.");
        UtilsMatrix.print2DComplexMatrix(threadsIncorporated.barrier.getResult());
    }
}
