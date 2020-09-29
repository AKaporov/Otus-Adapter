import interfaces.MathOperationWithSquareMatrix;

import java.util.ArrayList;

public class SquareMatrixImpl implements MathOperationWithSquareMatrix {

    private ArrayList<int[][]> matrix;

    public SquareMatrixImpl(ArrayList<int[][]> matrix) {
        this.matrix = matrix;
    }

    @Override
    public int[][] plusIntMatrixList() {
        if (this.matrix.size() == 0) {
            return new int[0][0];
        }

        int lengthMatrix = this.matrix.get(0).length;
        int[][] result = new int[lengthMatrix][lengthMatrix];

        for (int i = 0; i < lengthMatrix; i++) {
            for (int j = 0; j < lengthMatrix; j++) {
                result[i][j] = getSumAllValueSpecifiedMatrixElement(this.matrix, i, j);
            }
        }

        return result;
    }

    /*
     Сумма всех значений указанного элемента матриц
    */
    private int getSumAllValueSpecifiedMatrixElement(ArrayList<int[][]> matrixList, int lineNumber, int rowNumber) {
        int result = 0;

        for (int[][] matrix : matrixList) {
            result += matrix[lineNumber][rowNumber];
        }
        return result;
    }

}