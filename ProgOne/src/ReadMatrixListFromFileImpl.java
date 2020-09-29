import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

public class ReadMatrixListFromFileImpl implements ReadMatrixListFromFile {

    private final String RESULTPATH = "InputFile\\";
    private final String FILENAME = "FileZero.txt";

    /*
    Метод конвертации строковой квадратной матрицы в целочисленную квадратную матрицц
    */
    @Override
    public ArrayList<int[][]> getIntMatrixListFromFile() {
        ArrayList<String> stringMatrixList = getStringSquareMatrixListFromFile();
        System.out.println("************ Read From File:");
        stringMatrixList.forEach((oneStringMatrix) -> System.out.println(oneStringMatrix));

        ArrayList<int[][]> intMatrixList = convertSquareMatrixListFromStringToInt(stringMatrixList);
        System.out.println("************ After Convert From String To Int:");
        intMatrixList.forEach((oneIntMatrix) -> System.out.println(Arrays.deepToString(oneIntMatrix)));

        return intMatrixList;
    }

    private ArrayList<String> getStringSquareMatrixListFromFile() {
        ArrayList<String> list = new ArrayList<>();

        try {
            FileReader reader = new FileReader(new File(RESULTPATH + FILENAME).getAbsoluteFile());
            try {
                if (reader.ready()) {
                    BufferedReader br = new BufferedReader(reader);

                    String oneLine = br.readLine().trim();

                    while ((oneLine != null) & (!oneLine.isEmpty())){
                        list.add(oneLine);
                        oneLine = br.readLine().trim();
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return list;
    }

    private ArrayList<int[][]> convertSquareMatrixListFromStringToInt(ArrayList<String> stringSquareMatrixList) {
        ArrayList<int[][]> intMatrixList = new ArrayList<>();

        if (stringSquareMatrixList.isEmpty()) {
            return intMatrixList;
        }

        for (String matrix : stringSquareMatrixList) {
            int length = getSquareMatrixLength(matrix);
            if (length != 0) {
                int[][] squareMatrix = convertStringMatrixToIntMatrix(matrix, length);
                intMatrixList.add(squareMatrix);
            }
        }

        return intMatrixList;
    }

    private int[][] convertStringMatrixToIntMatrix(String strMatrix, int lengthIntMatrix) {
        int[][] result = new int[lengthIntMatrix][lengthIntMatrix];

        strMatrix = excludeExtraCharFromString(strMatrix);
        String[] arrayStrMatrix = getStringMatrixArray(strMatrix);

        int k = 0;
        for (int i = 0; i < lengthIntMatrix; i++) {
            for (int j = 0; j < lengthIntMatrix; j++) {
                result[i][j] = Integer.valueOf(arrayStrMatrix[k++].trim());
            }
        }

        return result;
    }

    private String[] getStringMatrixArray(String strMatrix) {
        return strMatrix.trim().split("\\,");
    }

    private String excludeExtraCharFromString(String strMatrix) {
        strMatrix = strMatrix.replaceAll("\\[", " ");
        strMatrix = strMatrix.replaceAll("\\]", " ");

        return strMatrix;
    }

    private int getSquareMatrixLength(String matrix) {
        return matrix.split("],").length;
    }
}
