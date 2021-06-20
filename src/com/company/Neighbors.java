package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Neighbors {
    public static void main(String[] args) throws IOException {
//        StringBuilder output_buffer = new StringBuilder();
//        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
//        int num_lines = Integer.parseInt(reader.readLine());
//        for (int i = 0; i < num_lines; ++i) {
//            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
//            int value_1 = Integer.parseInt(tokenizer.nextToken());
//            int value_2 = Integer.parseInt(tokenizer.nextToken());
//            int result = value_1 + value_2;
//            output_buffer.append(result).append("\n");
//        }
//        System.out.println(output_buffer.toString());


//        int [][] twoDimArray = {{5,7,3,17},
//                                {7,0,1,12},
//                                {8,1,2,3}};
//        for (int i = 0; i < 3; i++) {  //идём по строкам
//            for (int j = 0; j < 4; j++) {//идём по столбцам
//                System.out.print(" " + twoDimArray[i][j] + " "); //вывод элемента
//            }
//            System.out.println();//перенос строки ради визуального сохранения табличной формы
//        }
//        int coordinateY = 0;
//        int coordinateX = 1;
//        int rightNeighbor = 0;
//        int leftNeighbor = 0;
//        int upNeighbor = 0;
//        int downNeighbor = 0;
//        if (twoDimArray[coordinateY][coordinateX+1] == 1)
//             rightNeighbor = twoDimArray[coordinateY][coordinateX+1];
//         if (twoDimArray[coordinateY][coordinateX-1] == 1)
//            leftNeighbor = twoDimArray[coordinateY][coordinateX-1];
//        if (twoDimArray[coordinateY+1][coordinateX] == 1)
//            upNeighbor = twoDimArray[coordinateY+1][coordinateX];
//        if (twoDimArray[coordinateY-1][coordinateX-1] == 1)
//            downNeighbor = twoDimArray[coordinateY-1][coordinateX-1];
//        System.out.print("\nПравый сосед: " + rightNeighbor +
//                        "\n Левый сосед: " + leftNeighbor +
//                        "\n Верхний сосед: " + upNeighbor +
//                        "\n Нижний сосед сосед: " + downNeighbor);

        int n = 2;
        int m = 3;
        int twoDimArray[][] = new int[n][m];
        String firstLine = "1 2 3";
        int[] numArr = Arrays.stream(firstLine.split(" ")).mapToInt(Integer::parseInt).toArray();
        for (int i = 0; i < m; i++) {
            twoDimArray[0][i] = numArr[i];
            System.out.print(twoDimArray[0][i]);
        }
}}
