package com.company.sprint3;

public class Solution {
    public static int brokenSearch(int[] arr, int k, int left, int right) {
        if (right >= left) {
            int mid = (left + right + 1) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            else if (arr.length == 1) {
                if (arr[0] == k) {
                    return mid;
                }
            }
            else if (arr.length == 2) {
                if (arr[0] == k) {
                    return 0;
                }
                else if (arr[1] == k) {
                    return 1;
                }
            }
            else if (arr[left] <= arr[mid]) {
                if (k <= arr[mid]) {
                    return brokenSearch(arr, k, left, mid - 1);
                }
                else {
                    return brokenSearch(arr, k, mid + 1, right);
                }
            }
            else {
                if (k > arr[mid]) {
                    return brokenSearch(arr, k, left, mid - 1);
                }
                int leftToMid = brokenSearch(arr, k, left, mid - 1);
                if (leftToMid != -1) {
                    return leftToMid;
                }
                return brokenSearch(arr, k, mid + 1, right);
            }
        }
        return -1;
    }
    public static int brokenSearch(int[] arr, int k) {
        int left = 0;
        int right = arr.length - 1;
        if (right >= left) {

            int mid = (left + right + 1) / 2;
            if (arr[mid] == k) {
                return mid;
            }
            else if (arr.length == 1) {
                if (arr[0] == k) {
                    return mid;
                }
            }
            else if (arr.length == 2) {
                if (arr[0] == k) {
                    return 0;
                }
                else if (arr[1] == k) {
                    return 1;
                }
            }
            else if (arr[left] <= arr[mid]) {
                if (k <= arr[mid]) {
                    return brokenSearch(arr, k, left, mid - 1);
                }
                else {
                    return brokenSearch(arr, k, mid + 1, right);
                }
            }
            else {
                if (k <= arr[mid]) {
                    return brokenSearch(arr, k, left, mid - 1);
                }
                int leftToMid = brokenSearch(arr, k, left, mid - 1);
                if (leftToMid != -1) {
                    return leftToMid;
                }
                return brokenSearch(arr, k, mid + 1, right);
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {851, 852, 854, 855, 856, 860, 861, 862, 864, 865, 867, 868, 871, 872, 873, 874, 877, 878, 879, 882, 884, 885, 886, 890, 892, 893, 894, 895, 896, 897, 898, 899, 900, 901, 902, 903, 907, 908, 909, 910, 911, 912, 913, 914, 917, 918, 920, 921, 922, 923, 925, 926, 927, 928, 930, 931, 933, 934, 935, 937, 938, 939, 940, 941, 943, 944, 945, 946, 949, 951, 957, 959, 961, 963, 965, 966, 969, 970, 971, 972, 974, 975, 976, 978, 980, 981, 982, 983, 987, 988, 989, 991, 992, 993, 994, 995, 996, 998, 999, 1000, 0, 1, 2, 7, 8, 9, 11, 13, 16, 18, 20, 22, 23, 25, 26, 28, 30, 31, 34, 39, 40, 41, 43, 45, 46, 47, 50, 51, 53, 56, 57, 58, 59, 60, 61, 64, 65, 66, 67, 68, 69, 70, 71, 74, 77, 78, 79, 80, 82, 83, 85, 86, 87, 88, 90, 92, 94, 96, 97, 99, 101, 102, 104, 105, 106, 107, 108, 109, 111, 113, 114, 115, 117, 120, 124, 125, 127, 129, 132, 134, 135, 138, 140, 141, 144, 146, 147, 148, 150, 151, 153, 155, 156, 157, 158, 159, 160, 162, 165, 167, 169, 171, 172, 173, 174, 175, 179, 183, 185, 186, 187, 188, 189, 190, 191, 192, 195, 196, 197, 198, 200, 201, 203, 204, 205, 207, 208, 209, 210, 211, 212, 213, 214, 215, 216, 217, 218, 219, 222, 223, 224, 226, 227, 228, 229, 230, 231, 232, 233, 234, 235, 236, 237, 238, 239, 241, 242, 243, 245, 246, 247, 248, 250, 252, 254, 255, 256, 257, 258, 265};
        System.out.println(brokenSearch(arr, 255));
    }
}
