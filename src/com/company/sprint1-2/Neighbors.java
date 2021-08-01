import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Neighbors {
    public static void main(String[] args) throws IOException {
        StringBuilder output_buffer = new StringBuilder();
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

        int X = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());
        if ((X < n & Y < m) && (X >= 0 && Y >= 0)) {
            if (X + 1 < n & X != n - 1)
                output_buffer.append(twoDimArray[X + 1][Y]).append(" ");
            if (X != 0) {
                output_buffer.append(twoDimArray[X - 1][Y]).append(" ");
            }
            if (Y + 1 < m & Y != m - 1)
                output_buffer.append(twoDimArray[X][Y + 1]).append(" ");
            if (Y != 0) {
                output_buffer.append(twoDimArray[X][Y - 1]).append(" ");
            }
        }

        String output_string = output_buffer.toString();
        int[] numArr = Arrays.stream(output_string.split(" ")).mapToInt(Integer::parseInt).toArray();
        Arrays.sort(numArr);
        for (int i = 0; i < numArr.length; i++) {
            System.out.print(numArr[i] + " ");
        }
    }
}
