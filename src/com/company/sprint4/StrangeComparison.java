/*
Жители Алгосского архипелага придумали новый способ сравнения строк. Две строки считаются равными, если символы одной из них можно заменить на символы другой так, что первая строка станет точной копией второй строки. При этом необходимо соблюдение двух условий:

Порядок вхождения символов должен быть сохранён.
Одинаковым символам первой строки должны соответствовать одинаковые символы второй строки. Разным символам —– разные.
Например, если строка s = «abacaba», то ей будет равна строка t = «xhxixhx», так как все вхождения «a» заменены на «x», «b» –— на «h», а «c» –— на «i». Если же первая строка s=«abc», а вторая t=«aaa», то строки уже не будут равны, так как разные буквы первой строки соответствуют одинаковым буквам второй.

 */
package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class StrangeComparison {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        String t = reader.readLine();
        if (s.length() > 1000000 || t.length() > 1000000) {
            throw new Exception("Длина s или t больше 1000000");
        }
        if (s.length() < 1 || t.length() < 1) {
            throw new Exception("Длина s или t меньше одного");
        }
        if ((!s.matches("[a-z]*")) || (!t.matches("[a-z]*"))) {
            throw new Exception("Не соответствует маленьким латинским буквам");
        }
        isStrangeEqual(s, t);
    }

    public static void isStrangeEqual(String first, String second) {
        StringBuilder output = new StringBuilder(first);
        Map<Integer, Boolean> replaced = new LinkedHashMap<>();
        for (int i = 0; i < first.length(); i++) {
            replaced.put(i, false);
        }
        ArrayList<Character> replacedList = new ArrayList<>();

        for (int i = 0; i < first.length(); i++) {
            char temp = output.charAt(i);
            for (int j = 0; j < first.length(); j++) {
                if (output.charAt(j) == temp && !replaced.get(j) && !replacedList.contains(output.charAt(j))) {
                    output.setCharAt(i, second.charAt(i));
                    replaced.put(i, true);
                    replacedList.add(output.charAt(j));
                }
            }
        }
        System.out.println(output);
    }
}
