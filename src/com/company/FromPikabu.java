package com.company;

public class FromPikabu {
    public static void main(String[] args) {
        String input = "AAAABBBBCCCCCCCDDDDDE";
        String output = RLE(input);
        System.out.print(output);
    }

    private static String RLE(String s) {
        int counter = 0;
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if ((i != s.length() - 1) && (s.charAt(i) == s.charAt(i + 1))) {
                counter += 1;
            }
            else {
                if (counter == 0) {
                    output.append(s.charAt(i));
                }
                else {
                    output.append(s.charAt(i)).append(counter + 1);
                    counter = 0;
                }
            }
        }
        return output.toString();
    }
}
