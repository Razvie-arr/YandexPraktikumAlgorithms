package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.util.LinkedList;
import java.util.Stack;

public class BracketSequence {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String sequence = reader.readLine();
        if (isCorrectSequence(sequence)) {
            System.out.print("True");
        }
        else {
            System.out.print("False");
        }
    }

    static boolean isCorrectSequence(String sequence) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < sequence.length(); i++) {
            int ch = sequence.charAt(i);
            switch (ch) {
                case '(':
                    stack.push(')');
                    break;
                case '[':
                    stack.push(']');
                    break;
                case '{':
                    stack.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (stack.isEmpty()) {
                        return false;
                    }
                    final char top = stack.pop();
                    if (top != ch) {
                        return false;
                    }
            }
        }
        return stack.isEmpty();
    }
}
