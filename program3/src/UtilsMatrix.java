import java.util.StringJoiner;

/**
 * UtilsMatrix class contatins utility functions for matrix manipulations.
 */
class UtilsMatrix {
    private final static String doubleFormat = "%6.1f";

    /**
     * Creates 2D matrix for the given sizes.
     *
     * @param rowSize row length of matrix
     * @param colSize column length of matrix
     * @return 2D Complex array
     */
    static Complex[][] createComplexMatrix(int rowSize, int colSize) {
        Complex[][] complex = new Complex[rowSize][colSize];
        for (int i = 0; i < rowSize; i++) {
            for (int j = 0; j < colSize; j++) {
                complex[i][j] = new Complex();
            }
        }
        return complex;
    }

    /**
     * Converts double 2D matrix to string
     * @param matrix double 2D matrix
     * @return string representation of double 2D matrix
     */
    private static String str2DMatrix(double[][] matrix) {
        StringBuilder sb = new StringBuilder();
        for (double[] row : matrix) {
            StringJoiner sj = new StringJoiner(" | ");
            for (double col : row) {
                sj.add(String.format(doubleFormat, col));
            }
            sb.append(sj).append("\n");
        }
        return sb.toString();
    }

    /**
     * Prints the given Complex matrix.
     * @param matrix matrix
     */
    static void print2DComplexMatrix(Complex[][] matrix) {
        String result =
                "_________\nReal Part\n_________\n" +
                        str2DMatrix(UtilsMatrix.getRealPart2D(matrix)) +
                "\n_________\nImag Part\n_________\n" +
                        str2DMatrix(UtilsMatrix.getImagPart2D(matrix));
        System.out.print(result);
    }

    /**
     * It creates double array from the given Complex matrix by extracting the real fields.
     * @param matrix Complex matrix
     * @return real part of the given Complex matrix
     */
    private static double[][] getRealPart2D(Complex[][] matrix) {
        double[][] realPart;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        else {
            realPart = new double[matrix.length][matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                realPart[i][j] = matrix[i][j].real;
            }
        }
        return realPart;
    }

    /**
     * It creates double array from the given Complex matrix by extracting the imag fields.
     * @param matrix Complex matrix
     * @return imaginary part of the given Complex matrix
     */
    private static double[][] getImagPart2D(Complex[][] matrix) {
        double[][] imagPart;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return null;
        }
        else {
            imagPart = new double[matrix.length][matrix[0].length];
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                imagPart[i][j] = matrix[i][j].imag;
            }
        }
        return imagPart;
    }

    /**
     * Calculates the sum of two complex matrices.
     * @param A matrix A
     * @param B matrix B
     * @return matrix A+B
     */
    static Complex[][] sumTwoComplexMatrices(Complex[][] A, Complex[][] B) {
        Complex[][] sum = null;
        if (A != null && B != null && A.length == B.length &&
                A[0] != null && B[0] != null && A[0].length == B[0].length) {
            sum = new Complex[A.length][A[0].length];
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < A[0].length; j++) {
                    sum[i][j] = Complex.add(A[i][j], B[i][j]);
                }
            }
        }
        return sum;
    }

    /**
     * Returns transpose of two complex matrices.
     * @param matrix Complex 2D matrix
     * @return transpose(matrix)
     */
    static Complex[][] transpose2DComplexMatrix(Complex[][] matrix) {
        int row = 0, col = 0;
        if (matrix != null) {
            row = matrix.length;
            col = matrix[0].length;
        }
        Complex[][] transpose = createComplexMatrix(col, row);
        for (int i = 0; i < col; i++) {
            for (int j = 0; j < row; j++) {
                transpose[i][j] = matrix[j][i];
            }
        }
        return transpose;
    }

    /**
     * It changes all the real numbers of the given Complex matrix.
     * @param A updated Complex matrix
     * @param BReal inserted array of real values.
     */
    static void setRealPart2D(Complex[][] A, double[][] BReal) {
        for (int i = 0; i < BReal.length; i++) {
            for (int j = 0; j < BReal[i].length; j++) {
                A[i][j].real = BReal[i][j];
            }
        }
    }

}
