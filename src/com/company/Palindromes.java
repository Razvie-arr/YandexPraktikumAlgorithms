package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = reader.readLine();
        if (isPalindrome(phrase)) {
            System.out.println("True");
        }
        else {
            System.out.println("False");
        }

    }
    public static boolean isPalindrome(String phrase) {
        if (!phrase.matches("^[A-Za-z0-9-.?!)(,: ]+$")) {
            System.exit(0);
        }
        else {
            int lenghtOfPhrase = phrase.length();
            //проверка на длину (должно быть меньше или равно 20000)
            if (lenghtOfPhrase > 20000) {
                System.exit(0);
            }
            else {
                StringBuilder purePhrase = new StringBuilder();
                StringBuilder reversedPhrase= new StringBuilder();
                for (int i = 0; i < lenghtOfPhrase; i++) {
                    if (Character.isLetterOrDigit(phrase.charAt(i))) {
                        purePhrase.append(phrase.charAt(i));
                        reversedPhrase.insert(0, phrase.charAt(i));
                    }
                }
                String pureLower = purePhrase.toString().toLowerCase();
                String reversedLower = reversedPhrase.toString().toLowerCase();

                return pureLower.equals(reversedLower);
            }
        }
        return false;
    }

}
