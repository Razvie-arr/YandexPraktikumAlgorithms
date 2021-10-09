package com.company.sprint3;

/*
https://contest.yandex.ru/contest/23815/run-report/52733402/
-- ПРИНЦИП РАБОТЫ --
Реализован метод  brokenSearch, который принимает массив arr и искомое число k (пришлось использовать перегрузку методов и дублировать код,
т.к сигнатура заготовки не позволила использовать сразу метод, который принимает в себя arr, k, left, right).
Далее ищем отсортированную сторону массива и используем на ней классический бинарный поиск

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Поиск искомого элемента производится за O(log n)

-- ПРОСТРАНСТВЕННАЯ СЛОЖНОСТЬ --
Пространственная сложность как и у классического бинарного поиска - О(1)

 */
public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[mid] == k) return mid;

            if (arr[left] <= arr[mid]) {
                if (arr[left] <= k && k < arr[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if (arr[mid] < k && k <= arr[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return - 1;
    }
}
