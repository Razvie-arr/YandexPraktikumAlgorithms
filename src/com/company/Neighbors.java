package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Neighbors {
    public static void main(String[] args) throws IOException {
        StringBuilder output_buffer = new StringBuilder();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        int m = Integer.parseInt(reader.readLine());
        int twoDimArray[][] = new int[n][m];
        for (int i = 0; i < n; i++) {
            StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
            for (int j = 0; j < m; j++) {
                twoDimArray[i][j] = Integer.parseInt(tokenizer.nextToken());
            }
        }
        int X = Integer.parseInt(reader.readLine());
        int Y = Integer.parseInt(reader.readLine());
        //визуализация матрицы
        for (int i = 0; i < n; i++) {  //идём по строкам
            for (int j = 0; j < m; j++) {//идём по столбцам
                System.out.print(" " + twoDimArray[i][j] + " "); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
        System.out.print(twoDimArray[X][Y+1] + "\n");
        System.out.print(twoDimArray[X+1][Y]);
//        int rightNeighbor = 0;
//        int leftNeighbor = 0;
//        int upNeighbor = 0;
//        int downNeighbor = 0;
//        if (twoDimArray[X][Y+1] == 1)
//            rightNeighbor = twoDimArray[X][Y+1];
//        if (twoDimArray[X][Y-1] == 1)
//            leftNeighbor = twoDimArray[X][Y-1];
//        if (twoDimArray[X+1][Y] == 1)
//            upNeighbor = twoDimArray[X+1][Y];
//        if (twoDimArray[X-1][Y] == 1)
//            downNeighbor = twoDimArray[X-1][Y];
//        System.out.print("\nПравый сосед: " + rightNeighbor +
//                "\n Левый сосед: " + leftNeighbor +
//                "\n Верхний сосед: " + upNeighbor +
//                "\n Нижний сосед сосед: " + downNeighbor);
    }


}
