package osman_kartal_ooad_hw1_p1;

/**
 * SolvingLinearSystemBehavior is the interface that provides different
 * linear system solving methods to a LinearSystemSolver object by
 * declaring an abstract method.
 * It contains linear system solving method to be implemented.
 *
 * @author Osman Kartal
 */
public interface SolvingLinearSystemBehavior {
    /**
     * Linear System solving method to be implemented
     *
     * @param matrix 2D matrix of the linear system
     * @param vector vector of the linear system
     */
    void solve(double[][] matrix, double[] vector);
}
