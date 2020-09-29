package SaveMatrix;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;

/*

Класс для сохранения матрицы в файл.
Если имя файла не передано, то сохраняется по пути указаном в TEMP/TMP с префиксом Otus_FileName
(напрмиер, C:\Windows\Temp\Otus_FileName17321303727237893112.tmp)

*/

public class SaveSquareMaxtrixInFileImpl implements SaveSquareMatrix {
    private final String RESULTPATH = "ResultFile\\";
    private String fileName;

    public SaveSquareMaxtrixInFileImpl(String fileName) {
        if (fileName.isEmpty()) {
            fileName = "Otus_File_Name";
        }
        this.fileName = fileName;
    }

    @Override
    public void saveMatrixsList(ArrayList<int[][]> matrixList) {
        try {
            String absolutePath = new File(RESULTPATH + fileName).getAbsolutePath();

            OutputStream out = new FileOutputStream(absolutePath);
            PrintWriter printWriter = new PrintWriter(out);

            for (int[][] array: matrixList) {
                printWriter.println(Arrays.deepToString(array));
            }

            out.flush();
            printWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (NullPointerException e) {
            e.printStackTrace();
        }
    }
}
