    package com.company.sprint4.Final;

    import java.io.BufferedReader;
    import java.io.IOException;
    import java.io.InputStreamReader;
    import java.util.ArrayList;
    import java.util.regex.Matcher;
    import java.util.regex.Pattern;

    class Hasher {
        /* Класс узла связного списка . Используется только в хэш-таблице,
         * реализуется в виде двусвязного списка . */
        private static class LinkedListNode {
            public LinkedListNode next;
            public LinkedListNode prev;
            public int key;
            public int value;
            public LinkedListNode(int k, int v) {
                key = k;
                value = v;
            }
        }

        private ArrayList<LinkedListNode> arr;
        public Hasher(int capacity) {
            /* Создание списка связных списков . Список заполняется значениями
             * пull (единственный способ создания массива заданного размера ). */
            arr = new ArrayList<LinkedListNode>();
            arr.ensureCapacity(capacity);
            for (int i = 0; i < capacity; i++) {
                arr.add(null);
            }
        }

        /* Вставка ключа и значения в хэш-таблицу . */
        public Integer put(int key, int value) {
            LinkedListNode node = getNodeForKey(key);
            if (node != null) {
                int oldValue = node.value;
                node.value = value; // Просто обновить значение.
                return oldValue;
            }

            node = new LinkedListNode(key, value);
            int index = getIndexForKey(key);
            if (arr.get(index) != null) {
                node.next = arr.get(index);
                node.next.prev = node;
            }
            arr.set(index, node);
            return null;
        }

        /* Удаление узла для ключа . */
        public Integer remove(int key) {
            LinkedListNode node = getNodeForKey(key);
            if (node == null) {
                return null;
            }

            if (node.prev != null) {
                node.prev.next = node.next;
            } else {
                /* Удаление начального узла - обновление. */
                int hashKey = getIndexForKey(key);
                arr.set(hashKey, node.next);
            }

            if (node.next != null) {
                node.next.prev = node.prev;
            }
            return node.value;
        }

        /* Получение значения для ключа . */
        public Integer get(Integer key) {
            if (key == null) return null;
            LinkedListNode node = getNodeForKey(key);
            return node == null ? null : node.value;
        }

        /* Получение узла связного списка для заданного ключа . */
        private LinkedListNode getNodeForKey(int key) {
            int index = getIndexForKey(key);
            LinkedListNode current = arr.get(index);
            while (current != null) {
                if (current.key == key) {
                    return current;
                }
                current = current.next;
            }
            return null;
        }

        /* Очень наивная функция для связывания ключа с индексом . */
        public int getIndexForKey(Integer key) {
            return Math.abs(key.hashCode() % arr.size());
        }
    }

    public class Fina1 {
        public static void main(String[] args) throws IOException {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            StringBuilder output = new StringBuilder();
            Hasher customMap = new Hasher(n / 2);
            for (int i = 0; i < n; i++) {
                String command = reader.readLine();
                if (command.contains("get")) {
                    Integer recievedValue = customMap.get(findNumberInCommand(command, 1));
                    if (recievedValue == null) {
                        output.append("None").append("\n");
                    } else {
                        output.append(recievedValue).append("\n");
                    }
                }
                if (command.contains("put")) {
                    customMap.put(findNumberInCommand(command, 1), findNumberInCommand(command, 2));
                }
                if (command.contains("delete")) {
                    Integer deletedValue = customMap.remove(findNumberInCommand(command, 1));
                    if (deletedValue == null) {
                        output.append("None").append("\n");
                    } else {
                        output.append(deletedValue).append("\n");
                    }
                }
            }
            output.setLength(output.length() - 1);
            System.out.println(output);
        }

        public static int findNumberInCommand(String command, int n) {
            final Pattern pattern = Pattern.compile("\\d+");
            final Matcher matcher = pattern.matcher(command);

            final int[] ints = new int[n];
            for (int i = 0; i < n; i++) {
                matcher.find();
                ints[i] = Integer.parseInt(matcher.group());
            }
            if (n == 1) {
                return ints[0];
            }
            return ints[1];
        }
    }
