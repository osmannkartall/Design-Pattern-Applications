package osman_kartal_ooad_hw1_p1;

import java.util.Arrays;
import java.util.Random;

/**
 * SolveWithGaussianElimination is the class that provides implementation of
 * Gaussian Elimination method by implementing SolvingLinearSystemBehavior.
 * Note: Random boolean value is generated to simulate success and failure
 *       operation instead of implementing Gaussian Elimination.
 *
 * @author Osman Kartal
 */
public class SolveWithGaussianElimination implements SolvingLinearSystemBehavior{
    /**
     * It simulates the result of success and failure operation
     * of Matrix Inversion for the given linear system.
     *
     * @param matrix 2D matrix of the linear system
     * @param vector vector of the linear system
     */
    public void solve(double[][] matrix, double[] vector) {
        Random random = new Random();
        double solution = 0.0;
        System.out.println("matrix" + Arrays.deepToString(matrix));
        System.out.println("vector" + Arrays.toString(vector));

        if (random.nextBoolean()) {
            // Find the solution.
            System.out.println("The result with Gaussian Elimination approach is: " + solution);
        }
        else {
            // Print error message.
            System.out.println("There is no solution that can be generated by using Gaussian Elimination.");
        }
    }
}
