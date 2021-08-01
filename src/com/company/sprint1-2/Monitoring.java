import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Monitoring {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());

        int[][] twoDimArray = new int[n][m];

        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                twoDimArray[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        matrixTranspose(twoDimArray, n, m);
    }

    private static void matrixTranspose(int[][] matrix, int n, int m) {
        int[][] newMatrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                newMatrix[i][j] = matrix[j][i];
            }
        }

        printMatrix(newMatrix);
    }

    private static void printMatrix(int[][] matrix) {
        StringBuilder stringMatrix = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                stringMatrix.append(matrix[i][j]).append(" ");
            }

            stringMatrix.append("\n");
        }
        System.out.print(stringMatrix);
    }
}