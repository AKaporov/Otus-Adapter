package savesquarematrix;

import java.util.ArrayList;
import java.util.Arrays;

/*
Класс для сохранения матрицы в консоль
*/
public class SaveSquareMatrixInConsolImpl implements SaveSquareMatrix {
    @Override
    public void saveMatrixsList(ArrayList<int[][]> matrixList) {

        matrixList.forEach((array) -> {
            System.out.println(Arrays.deepToString(array));
        });
    }
}
