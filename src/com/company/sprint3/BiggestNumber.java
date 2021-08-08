package com.company.sprint3;

import java.util.Arrays;

class BiggestNumber {
    public static void main(String[] args) {
        int[] nums = new int[]{2, 4, 5, 2, 10};
        BiggestNumber biggy = new BiggestNumber();
        System.out.print(biggy.largestNumber(nums));
    }
    public String largestNumber(int[] nums) {
        String [] s = new String [nums.length];
        int len=0;
        boolean hasNonZero = false;
        for (int i = 0; i < nums.length; i++) {
            int n = nums[i];
            if (n > 0) hasNonZero = true;
            String t = String.valueOf(n);
            len += t.length();
            s[i] = t;
        }
        if (!hasNonZero) return "0";

        Arrays.sort(s, (a, b) -> this.compare(b,a));
        StringBuilder sb = new StringBuilder(len);
        for (String t : s) {
            sb.append(t);
        }
        return sb.toString();
    }

    // AB ABY ==> ABABY vs ABYAB
    // AB > ABY if A > Y 
    private static int compare(String a, String b) {
        int a_len = a.length();
        int b_len = b.length();
        int len = a_len == b_len ? a_len : a_len + b_len;
        for (int i=0; i < len; i++) {
            char ac = i < a_len ? a.charAt(i) : b.charAt(i-a_len);
            char bc = i < b_len ? b.charAt(i) : a.charAt(i-b_len);
            if (ac == bc) continue;
            return ac < bc ? -1 : 1;
        }
        return 0;
    }
}