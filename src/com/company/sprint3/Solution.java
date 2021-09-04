package com.company.sprint3;
/*
https://contest.yandex.ru/contest/23815/run-report/52627515/
-- ПРИНЦИП РАБОТЫ --
Реализован метод  brokenSearch, который принимает массив arr и искомое число k (пришлось использовать перегрузку методов и дублировать код,
т.к сигнатура заготовки не позволила использовать сразу метод, который принимает в себя arr, k, left, right).
Далее ищем отсортированную сторону массива и используем на ней классический бинарный поиск

-- ВРЕМЕННАЯ СЛОЖНОСТЬ --
Поиск искомого элемента производится за O(log n)


 */
public class Solution {
    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        int mid = (left + right) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (right >= left) {
            //получается левая часть отсортирована
            if (arr[left] <= arr[mid]) {
                int leftToMid = binarySearch(arr, k, left, mid - 1);
                if (leftToMid != - 1) {
                    return leftToMid;
                }
                return brokenSearch(arr, k, mid + 1, right);
            }
            else {
                int rightToMid = binarySearch(arr, k, mid + 1, right);
                if (rightToMid != -1) {
                    return rightToMid;
                }
                return brokenSearch(arr, k, left, mid - 1);
            }
        }
        return -1;
    }

    public static int brokenSearch(int[] arr, int k, int left, int right) {
        int mid = (left + right) / 2;
        if (arr[mid] == k) {
            return mid;
        }
        if (right >= left) {
            //получается левая часть отсортирована
            if (arr[left] <= arr[mid]) {
                int leftToMid = binarySearch(arr, k, left, mid - 1);
                if (leftToMid != - 1) {
                    return leftToMid;
                }
                return brokenSearch(arr, k, mid + 1, right);
            }
            else {
                int rightToMid = binarySearch(arr, k, mid + 1, right);
                if (rightToMid != -1) {
                    return rightToMid;
                }
                return brokenSearch(arr, k, left, mid - 1);
            }
        }
        return -1;
    }

    public static int binarySearch(int[] sortedArray, int key, int low, int high) {
        int index = -1;

        while (low <= high) {
            int mid = (low + high) / 2;
            if (sortedArray[mid] < key) {
                low = mid + 1;
            } else if (sortedArray[mid] > key) {
                high = mid - 1;
            } else if (sortedArray[mid] == key) {
                index = mid;
                break;
            }
        }
        return index;
    }

}
