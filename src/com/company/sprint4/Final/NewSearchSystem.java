package com.company.sprint4.Final;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class NewSearchSystem {
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
        HashMap<String, HashMap<Integer, Integer>> searchIndex = new HashMap<>();
        HashMap<Integer, Integer> searchIndexCounter = new HashMap<>();
        int index = 1;
        for (String document : documents) {
            String[] words = document.split(" ");
            for (String word : words) {
                if (!searchIndex.containsKey(word)) {
                    searchIndexCounter.put(index, 1);
                } else {
                    if (searchIndexCounter.containsKey(index)) {
                        searchIndexCounter.put(index, searchIndexCounter.get(index) + 1);
                    } else {
                        searchIndexCounter.put(index, 1);
                    }
                }
                searchIndex.put(word, new HashMap<Integer, Integer>(index, searchIndexCounter.get(index)));
            }
            index++;
        }

        for (String query : queries) {
            output.append(computeRelevance(documents, query)).append("\n");
        }
        System.out.println(output);
    }

    private static String computeRelevance(String[] documents, String query) {
        String[] splitQuery = query.split(" ");
        Map<String, Integer> relevance = new LinkedHashMap<>();
        StringBuilder ret = new StringBuilder();
        HashSet<String> uniqueQueryWords = new HashSet<>(Arrays.asList(splitQuery));

        for (String document : documents) {
            String[] splitDocument = document.split(" ");
            for (String word : splitDocument) {
                if (uniqueQueryWords.contains(word)) {
                    if (relevance.containsKey(document)) {
                        relevance.put(document, relevance.get(document) + 1);
                    } else {
                        relevance.put(document, 1);
                    }
                }
            }
        }

        Map<String, Integer> sortedRelevance = new LinkedHashMap<>();
        relevance.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x -> sortedRelevance.put(x.getKey(), x.getValue()));

        int counter = 0;
        int index = 1;
        for (Map.Entry<String, Integer> set : sortedRelevance.entrySet()) {
            if (counter == 5) {
                break;
            }
            for (String document : documents) {
                if (set.getKey().equals(document)) {
                    ret.append(index).append(" ");
                    break;
                }
                index++;
            }
            index = 1;
            counter++;
        }
        if (ret.length() > 0) {
            return ret.substring(0, ret.length() - 1);
        }
        return ret.toString();
    }
}
