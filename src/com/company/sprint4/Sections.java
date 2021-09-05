/*Задача "Кружки"
В компании, где работает Тимофей, заботятся о досуге сотрудников и устраивают различные кружки по интересам. Когда кто-то записывается на занятие, в лог вносится название кружка.
        По записям в логе составьте список всех кружков, в которые ходит хотя бы один человек.
        Пример
        Ввод
        8
        вышивание крестиком
        рисование мелками на парте
        настольный керлинг
        настольный керлинг
        кухня африканского племени ужасмай
        тяжелая атлетика
        таракановедение
        таракановедение
        Вывод
        вышивание крестиком
        рисование мелками на парте
        настольный керлинг
        кухня африканского племени ужасмай
        тяжелая атлетика
        таракановедение
 */
package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

public class Sections {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n > 10000) {
            throw new Exception("Количество записей больше 10000");
        }
        Map<String, Integer> sections = new LinkedHashMap<>();
        for (int i = 0; i < n; i++) {
            String section = reader.readLine();
            if (sections.containsKey(section)) {
                sections.replace(section, sections.get(section) + 1);
            }
            else {
                sections.put(section, 1);
            }
        }
        for (Map.Entry<String, Integer> section: sections.entrySet()) {
            System.out.println(section.getKey());
        }
    }
}
