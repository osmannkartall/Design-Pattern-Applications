package osman_kartal_ooad_hw1_p1;

import java.util.Random;

/**
 * LinearSolverDeluxeTester is the driver class for testing operations on classes
 * in p1 package.
 *
 * @author Osman Kartal
 */
public class LinearSolverDeluxeTester {
    public static void main(String[] args) {
        double[][] matrix = new double[3][3];
        double[] vector = new double[3];

        System.out.println("Run 1 ---------------------------------------------------------");
        fillMatrices(matrix, vector);
        LinearSolverDeluxe solver = new LinearSystemSolver(matrix, vector);
        solver.setSolvingBehavior(new SolveWithGaussianElimination());
        solver.applySolution();
        System.out.println("Run 2 ---------------------------------------------------------");
        fillMatrices(matrix, vector);
        solver.setSolvingBehavior(new SolveWithMatrixInversion());
        solver.applySolution();
        System.out.println("Run 3 ---------------------------------------------------------");
        fillMatrices(matrix, vector);
        solver.setSolvingBehavior(new SolveWithGaussianElimination());
        solver.applySolution();
    }

    private static void fillMatrices(double[][] matrix, double[] vector) {
        Random r = new Random();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrix[i][j] = Double.parseDouble(String.format("%.2f", 10 * r.nextDouble()));
            }
            vector[i] = Double.parseDouble(String.format("%.2f", 10 * r.nextDouble()));
        }
    }
}
