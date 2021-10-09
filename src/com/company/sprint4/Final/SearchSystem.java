/*
https://contest.yandex.ru/contest/24414/run-report/53142846/

-- ПРИНЦИП РАБОТЫ --
С помощью метода fillSearchIndex заполняем поисковый индекс в хэшмапу для всех документов (и делаем это всего раз, тем самым экономим время).
Для каждого запроса находим уникальные слова, прогоняем по нашему поисковому индексу и вычисляем релевантность каждого документа для запроса.
Помещаем релевантности в хэшмапу вида {номер документа: рейтинг релевантности}, далее происходит сортировка по рейтингу (по убыванию).
Совпавшие по рейтингу номера документов сортируются по возрастанию.

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Затрачиваем n времени на заполнение поискового индекса (n элементов), умножаем на время вычисления релевантности для каждого запроса m,
но т.к каждое слово запроса ищется в поисковом индексе, то умножаем еще на n. Получаем временную сложность: O(n^2 * m)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Тратим n памяти на хранение хэшмапы поискового индекса (n элементов), умножаем на хэшмапу сет для хранения уникальных слов
(в худшем случае все элементы запроса будут уникальными, то есть храним все элементы запроса m),
умножаем на хэшмап для хранения релевантности u (u - кол-во элементов),
также используем хэшмапу для отсортированных релевантностей u (тоже u, потому что храним такое же кол-во элементов).
Получаем пространственную сложность O(n * m * u^2)
 */

//время на заполнение таблицы n (от кол-ва элементов) * на m (вычисление релевантности для каждого запроса)
//пространств: хэшмап на поисковый индекс n * хэшмап на уникальные слова n * m хэшмап для релевантности * m для сортированной релевантности - n2 * m2
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

class SearchSystem {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 10000) {
            throw new Exception("Invalid n");
        }

        String[] documents = new String[n];
        for (int i = 0; i < n; i++) {
            documents[i] = reader.readLine();
        }

        int m = Integer.parseInt(reader.readLine());
        if (m < 1 || m > 10000) {
            throw new Exception("Invalid m");
        }

        String[] queries = new String[m];
        for (int i = 0; i < m; i++) {
            queries[i] = reader.readLine();
        }
        printRelevanceOfDocuments(documents, queries);
    }

    private static void printRelevanceOfDocuments(String[] documents, String[] queries) {
        StringBuilder output = new StringBuilder();
        HashMap<String, HashMap<Integer, Integer>> searchIndex = fillSearchIndex(documents);
        for (String query : queries) {
            output.append(computeRelevance(searchIndex, query)).append("\n");
        }
        System.out.println(output);
    }

    private static HashMap<String, HashMap<Integer, Integer>> fillSearchIndex(String[] documents) {
        HashMap<String, HashMap<Integer, Integer>> searchIndex = new HashMap<>();
        int index = 1;
        for (String document : documents) {
            String[] words = document.split(" ");
            for (String word : words) {
                if (!searchIndex.containsKey(word)) {
                    //IntelliJ  IDEA ругается и не дает скомпилировать, если не использовать finalIndex
                    int finalIndex = index;
                    searchIndex.put(word, new HashMap<>() {{ put(finalIndex, 1); }});
                } else {
                    HashMap<Integer, Integer> tempMap = searchIndex.get(word);
                    tempMap.put(index, tempMap.getOrDefault(index, 0) + 1);
                    searchIndex.put(word, tempMap);
                }
            }
            index++;
        }
        return searchIndex;
    }

    private static String computeRelevance(HashMap<String, HashMap<Integer, Integer>> searchIndex, String query) {
        String[] splitQuery = query.split(" ");
        Map<Integer, Integer> relevance = new HashMap<>();
        StringBuilder ret = new StringBuilder();
        HashSet<String> uniqueQueryWords = new HashSet<>(Arrays.asList(splitQuery));
        for (String word : uniqueQueryWords) {
            if (searchIndex.containsKey(word)) {
                HashMap<Integer, Integer> tempMap = searchIndex.get(word);
                if (relevance.isEmpty()) {
                    relevance.putAll(tempMap);
                } else {
                    for (Integer key : tempMap.keySet()) {
                        relevance.put(key, relevance.getOrDefault(key, 0) + tempMap.get(key));
                    }
                }
            }
        }

        Map<Integer, Integer> sortedRelevance = new LinkedHashMap<>();
        relevance.entrySet()
                .stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue(Comparator.reverseOrder()).thenComparing(Map.Entry.comparingByKey()))
                .forEachOrdered(x -> sortedRelevance.put(x.getKey(), x.getValue()));

        int counter = 0;
        for (Map.Entry<Integer, Integer> set :
                sortedRelevance.entrySet()) {
            if (counter == 5) {
                return ret.toString();
            }
            ret.append(set.getKey()).append(" ");
            counter++;
        }
        if (ret.length() > 0) {
            return ret.substring(0, ret.length() - 1);
        }
        return ret.toString();
    }
}
