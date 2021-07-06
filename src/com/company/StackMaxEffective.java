package com.company;
//https://stackoverflow.com/questions/45072627/what-is-the-fastest-way-to-search-the-maximum-element-in-a-stack-in-java
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class StackMaxEffective {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 100000) {
            throw new Exception();
        }
        int maxElem = 0;
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.equals("get_max")) {
                if (stack.size() == 0) {
                    System.out.println("None");
                }
                else {
                    System.out.println(maxElem);
                }
            }
            else if (command.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("error");
                }
                else {
                    int deleted = stack.pop();
                    if (deleted == maxElem && stack.size() != 0) {
                        maxElem = getMax(stack);
                    }
                }
            }
            else if (command.contains("push")) {
                int number = findNumberInCommand(command);
                if (stack.size() == 0) {
                    maxElem = number;
                }
                else {
                    if (number >= maxElem) {
                        stackMax.push(number);
                    }
                }
                stack.push(number);
            }
        }
    }
    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }

    public static int getMax(Stack<Integer> stack) {
            int max = stack.get(0);
            for (int i = 0; i < stack.size(); i++) {
                if (stack.get(i) > max) {
                    max = stack.get(i);
                }
            }
            return max;
    }

}
