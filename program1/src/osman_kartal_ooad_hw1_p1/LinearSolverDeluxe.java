package osman_kartal_ooad_hw1_p1;

/**
 * LinearSolverDeluxe is the abstract base class for various linear system solving methods
 * and new functionalities that can be added in the future.
 * A LinearSolverDeluxe object contains two dimensional matrix, single dimensional matrix
 * and SolvingLinearSystemBehavior reference for solving linear systems.
 *
 * @author Osman Kartal
 */
public abstract class LinearSolverDeluxe {
    SolvingLinearSystemBehavior solvingBehavior;
    double[][] matrix;
    double[] vector;

    public abstract void display();

    /**
     * Delegates solution operation to concrete classes.
     */
    void applySolution() {
        solvingBehavior.solve(matrix, vector);
    }

    /**
     * Sets current solving linear equation method dynamically.
     * @param solvingBehavior method of the solving linear equation
     */
    void setSolvingBehavior(SolvingLinearSystemBehavior solvingBehavior) {
        this.solvingBehavior = solvingBehavior;
    }
}
