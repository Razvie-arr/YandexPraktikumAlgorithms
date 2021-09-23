package com.company.sprint5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.stream.LongStream;

public class DifferentSearchTree {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 20) {
            throw new Exception("n > 20");
        }
        System.out.println(catalanFormula(n));
    }
//    public static int treeCount(int nNumberOfNodes)//unlabelled
//    {
//        if (nNumberOfNodes == 1 || nNumberOfNodes == 0)
//        {
//            return 1;
//        }
//        int num = 0;
//        //assign i nodes for left subtree and rest to right subtree
//        for (int i = 0; i <= nNumberOfNodes - 1; i++)	{
//            num = num + treeCount(i) * treeCount(nNumberOfNodes - 1 - i);
//        }
//        return num;
//    }
public static long factorialUsingStreams(int n) {
    return LongStream.rangeClosed(1, n)
            .reduce(1, (long x, long y) -> x * y);
}

    public static int catalanFormula(int n) {
        return (int) (factorialUsingStreams(2 * n) / (factorialUsingStreams(n) * factorialUsingStreams(n + 1)));
    }
}
