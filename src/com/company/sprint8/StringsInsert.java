package com.company.sprint8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class StringsInsert {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        HashMap<String, Integer> giftedStrings = new HashMap<>(n);
        for (int i = 0; i < n; i++) {
            StringTokenizer giftTokenizer = new StringTokenizer(reader.readLine(), " ");
            giftedStrings.put(giftTokenizer.nextToken(), Integer.parseInt(giftTokenizer.nextToken()));
        }

    }
    /*
    функция insert(string, index, substring):
    length = длина(string)
    shift = длина(substring)
    если index > length: # index == length - край строки
        ошибка! нет такой позиции
    расширить область памяти строки до размера length + shift
    если length > 0:
        # Если length == 0, делать сдвиг нет смысла.
        # Кроме того, не следует в вычислениях писать (length - 1),
        #   не проверив, что индекс не ноль.
        # В некоторых языках длина представляется беззнаковым целым числом,
        #   в таком случае (length - 1) будет равен не -1, а числу MAX_INT,
        #   и цикл станет некорректным. Мы этого избегаем.
        для i от (length - 1) до index включительно, с шагом -1:
            string[shift + i] = string[i]

    для i от 0 до (shift - 1):
        string[index + i] = substring[i]

     */
    public static void printStringWithGifts(String string, HashMap<String, Integer> gifts, int n) {

    }

    public static String insert(String string, int index, String substring) {
        int length = string.length();
        int shift = substring.length();
        if (index > length) {
            return null;
        }
        StringBuilder stringSB = new StringBuilder(string);
        if (length > 0) {
            for (int i = length -1; i <= index ; i++) {
                stringSB.replace(shift + i, i, String.valueOf(string.charAt(i)));
            }
        }
    }
}
