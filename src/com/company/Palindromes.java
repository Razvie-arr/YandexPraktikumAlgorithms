package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Palindromes {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String phrase = reader.readLine();
        int lenghtOfPhrase = phrase.length();
        Pattern patkirletter = Pattern.compile("[а-яА-Я]{1}");
        Matcher matkirletter = patkirletter.matcher(phrase);
        //проверка на длину (должно быть меньше или равно 20000)
        if (lenghtOfPhrase > 20000) {
            System.exit(0);
        }
        else if (matkirletter.matches()) {
            System.exit(0);
        }
        else {
            StringBuilder phraseSB = new StringBuilder();
            for (int i = 0; i < lenghtOfPhrase; i++) {
                if (Character.isLetterOrDigit(phrase.charAt(i))) {
                    phraseSB.append(phrase.charAt(i));
                }
            }
            String phraseWithoutSymbols = phraseSB.toString().toLowerCase();
            isPalindrome(phraseWithoutSymbols);
        }
    }
    public static void isPalindrome(String input) {
        System.out.println(input);
    }
}
