package osman_kartal_ooad_hw1_p1;

/**
 * LinearSystemSolver is the subclass of LinearSolverDeluxe.
 * It is used for generating a linear system
 * It initializes it's inherited data fields so that a linear system can be constructed.
 * It implements display method according to their needs.
 *
 * @author Osman Kartal
 */
public class LinearSystemSolver extends LinearSolverDeluxe {
    /**
     * Two parameter constructor
     * @param matrix 2D matrix of the linear system
     * @param vector vector of the linear system
     */
    LinearSystemSolver(double[][] matrix, double[] vector) {
        this.matrix = matrix;
        this.vector = vector;
    }

    /**
     * Displays information about itself.
     */
    public void display() {
        System.out.println("Linear System Solver");
    }
}
