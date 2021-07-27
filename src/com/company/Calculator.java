package com.company;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Calculator {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        String expression = reader.readLine();
        String[] splitExpression = expression.split(" ");

        for (int i = 0; i < splitExpression.length; i++) {
            if (isDigit(splitExpression[i])) {
                deque.add(Integer.parseInt(splitExpression[i]));
            }
            else {
                System.out.println(doProcessing(splitExpression[i], deque));
            }
        }
    }

    public static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int doProcessing(String s, ArrayDeque<Integer> deque) {
        try {
            if (s.equals("+")) {
                int additionAccum = deque.pollFirst() + deque.pollFirst();
                deque.pollFirst();
                if (!deque.isEmpty()) {
                    doProcessing(s, deque);
                }
                return additionAccum;
            }

            if (s.equals("-")) {
                int subtractAccum = deque.pollFirst() - deque.pollFirst();
                deque.pollFirst();
                return subtractAccum;
            }

            if (s.equals("*")) {
                int multiplyAccum = deque.pollFirst() * deque.pollFirst();
                deque.pollFirst();
                return multiplyAccum;
            }

            if (s.equals("/")) {
                int divideAccum = deque.pollFirst() / deque.pollFirst();
                deque.pollFirst();
                return divideAccum;
            }



        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
