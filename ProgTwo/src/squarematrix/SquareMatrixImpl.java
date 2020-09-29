package squarematrix;

import java.util.Arrays;
import java.util.Random;

public class SquareMatrixImpl implements FillMatrixRandom {
    public int[][] matrix;

    public SquareMatrixImpl(int matrixLength) {
        this.matrix = new int[matrixLength][matrixLength];
    }

    @Override
    public void fillMatrixRandom() {
        Random random = new Random(System.currentTimeMillis());

        for (int i = 0; i < this.matrix.length; i++) {
            for (int j = 0; j < this.matrix.length; j++) {
                this.matrix[i][j] = 1 + random.nextInt(10);
            }
        }
    }

    public String toString() {
        return "squarematrix.SquareMatrixImpl{" +
                "matrix=" + Arrays.deepToString(this.matrix) +
                '}';
    }
}
