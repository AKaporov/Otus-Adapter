/*

Адаптер для работы двух независимых программ. Описание применения шаблона в проекте
Цель: 1. Вы напишете адаптер, чтобы связать функционал двух отдельных программ в единый процесс.
Разберётесь с тем, как адаптер работает в случае вызова отдельных программ.
Получите навыки работы с формальными и фактическими параметрами передачи данных
2. Получите навык анализа системы - использовать или нет этот шаблон в проектной работе.

Написать простую консольную программу П1, с интерфейсом вызова И1, которая читает данные о двух матрицах А и В из файла F0,
складывает матрицы и сохраняет результат А+В в другой файл F1.
Написать вторую консольную программу П2, которая может генерить данные матриц А и В и писать их в файл с именем F2.
Чтобы она могла их просуммировать, следует сделать адаптер для программы П1, который позволит программе П2 вызвать П1.

1. Написать программу П1
2. Написать программу П2, включив туда адаптер вызова и использования программы П1
     (П2 должна использовать возможность П1 т.е. П2 должна прочитать данные о двух матрицах А и В из файоа F0, сложить матрицы и сохранить реультат А+В в другой файл F1.)
3. Написать автотест для проверки функционирования
4. Если потребуется использовать адаптер в проектной работе, предоставить описание в текстовом файле в GitHub репозитории где конкретно и в какой роли используется этот шаблон.
5. нарисовать диаграмму классов.

Онлайн UML диаграмма
https://www.diagrameditor.com/

*/

import adapters.ProgOneAdapter;
import interfaces.MathOperationWithSquareMatrix;
import savesquarematrix.SaveSquareMatrix;
import savesquarematrix.SaveSquareMatrixInConsolImpl;
import savesquarematrix.SaveSquareMatrixInFileImpl;
import squarematrix.SquareMatrixImpl;

import java.util.ArrayList;

public class ProgTwoApplication {
    public static void main(String[] args) {
        int matrixLength = 2;

        SquareMatrixImpl squareMatrixImplA = new SquareMatrixImpl(matrixLength);
        SquareMatrixImpl squareMatrixImplB = new SquareMatrixImpl(matrixLength);

        squareMatrixImplA.fillMatrixRandom();
        squareMatrixImplB.fillMatrixRandom();


        System.out.println("Создана матрица А = " + squareMatrixImplA);
        System.out.println("Создана матрица В = " + squareMatrixImplB);
        System.out.println("==============================");

        ArrayList<int[][]> matrixList = new ArrayList<>();
        matrixList.add(squareMatrixImplA.matrix);
        matrixList.add(squareMatrixImplB.matrix);

        // Вызов Адаптера
        MathOperationWithSquareMatrix adapter = new ProgOneAdapter(matrixList);
        ArrayList<int[][]> resultMatrix = new ArrayList<>();
        resultMatrix.add(adapter.plusIntMatrixList());


        SaveSquareMatrix inFile = new SaveSquareMatrixInFileImpl("FileTwo.txt");
        SaveSquareMatrix inConsol = new SaveSquareMatrixInConsolImpl();

        inFile.saveMatrixsList(resultMatrix);
        inConsol.saveMatrixsList(resultMatrix);
    }
}
