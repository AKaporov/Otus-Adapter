package adapters;

/*
Класс адаптер для интерфейса MathOperationWithSquareMatrix из ProgOne
*/

import interfaces.MathOperationWithSquareMatrix;

import java.util.ArrayList;

public class ProgOneAdapter implements MathOperationWithSquareMatrix {

    private ArrayList<int[][]> matrixlist;

    public ProgOneAdapter(ArrayList<int[][]> matrixlist) {
        this.matrixlist = matrixlist;
    }

    @Override
    public int[][] plusIntMatrixList() {
        if (this.matrixlist.size() == 0) {
            return new int[0][0];
        }

        int lengthMatrix = this.matrixlist.get(0).length;
        int[][] result = new int[lengthMatrix][lengthMatrix];

        for (int i = 0; i < lengthMatrix; i++) {
            for (int j = 0; j < lengthMatrix; j++) {
                result[i][j] = getSumAllValueSpecifiedMatrixElement(this.matrixlist, i, j);
            }
        }

        return result;
    }

    private int getSumAllValueSpecifiedMatrixElement(ArrayList<int[][]> matrixList, int lineNumber, int rowNumber) {
        int result = 0;

        for (int[][] matrix : matrixList) {
            result += matrix[lineNumber][rowNumber];
        }
        return result;
    }
}
