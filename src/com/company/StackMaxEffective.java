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
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackMax = new Stack<>();
        for (int i = 0; i < n; i++) {
            String command = reader.readLine();
            if (command.equals("get_max")) {
                System.out.println(getMax(stackMax));
            }
            else if (command.equals("pop")) {
                if (stack.size() == 0) {
                    System.out.println("error");
                }
                else {
                    int deleted = stack.pop();
                    String max = getMax(stackMax);
                    if (!max.equals("None") && deleted == Integer.parseInt(max)) {
                        stackMax.pop();
                    }
                }
            }
            else if (command.contains("push")) {
                int number = findNumberInCommand(command);
                String max = getMax(stackMax);
                if (!max.equals("None") && number >= Integer.parseInt(max)) {
                    stackMax.push(number);
                }
                stack.push(number);
            }
        }
    }
    public static int findNumberInCommand(String command) {
        String[] splittedCommand = command.split(" ");
        return Integer.parseInt(splittedCommand[1]);
    }

    public static String getMax(Stack<Integer> stackMax) {
        if (stackMax.size() == 0) {
            return "None";
        }
        else {
            return stackMax.peek().toString();
        }

    }

}
