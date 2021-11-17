package com.company.sprint8.Final;

/*
https://contest.yandex.ru/contest/26133/run-report/58266028/
-- ПРИНЦИП РАБОТЫ --
Строим бор с обьемом строчных букв английского алфавита, заполняем его, далее пользуясь динамическим программированием, находим
возможность разбиения на слова из словаря.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Строим бор O(n * m), где n - количество слов в словаре, а m - это количество букв в слове.
Заполняем увиденные буквы в боре, итерируемся по длине текста и внутри имеется еще один цикл по длине текста.
O(l ^ 2) - где l - это длина текста
Получаем 0(n * m + l ^ 2)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Бор содержит ∣Σ∣ символов, где ∣Σ∣ - это количество строчных английских букв 0(∣Σ∣)
Храним массив со всеми словами, 0(n), где n - это количество всех слов
Храним булевый массив seen, содержащий просмотренные/непросмотренные буквы всего текста, 0(l), где l - это кол-во букв текста
Получаем 0(∣Σ∣ + n + l)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

class Trie {
    //Trie - бор, содержащий английский алфавит (26 чисел)
    Trie[] children = new Trie[26];
    boolean isEndWord;
}

class HackTheExam {
    private void buildTrie(Trie root, List<String> wordDict) {
        // строим бор, терминальный узел - это (isEndWorld = true)
        for (String word: wordDict) {
            Trie current = root;
            for (char c : word.toCharArray()) {
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new Trie();
                }
                current = current.children[c - 'a'];
            }
            current.isEndWord = true;
        }
    }

    public boolean wordBreak(String s, List<String> wordDict) {
        Trie root = new Trie();
        buildTrie(root, wordDict);
        boolean[] seen = new boolean[s.length() + 1];
        seen[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            Trie current  = root;
            for (int j = i; current != null && j <= s.length(); j++) {
                char c = s.charAt(j - 1);
                // с помощью вычитания 'a', находим место буквы в английском алфавите
                current = current.children[c - 'a'];
                if (current != null && current.isEndWord && seen[i - 1]) {
                    seen[j] = true;
                }
            }
        }
        return seen[s.length()];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text = reader.readLine();
        int n = Integer.parseInt(reader.readLine());
        List<String> words = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            String word = reader.readLine();
            words.add(word);
        }
        HackTheExam hte = new HackTheExam();
        if (hte.wordBreak(text, words)) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}