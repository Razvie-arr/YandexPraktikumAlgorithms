package com.company.sprint4;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class NewSum4 {
    static class Pair{
        int i;
        int j;

        Pair(int x,int y){
            i=x;
            j=y;
        }
    }
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            int s = Integer.parseInt(reader.readLine());
            if (n < 0 || n > 1000) {
                throw new Exception("Invalid n");
            }
            if (s > 1000000000) {
                throw new Exception("Invalid s");
            }
            String[] stringArr = reader.readLine().split(" ");
            if (n != stringArr.length) {
                System.out.println(0);
                System.exit(0);
            }
            int[] x = getIntegerArrayList(stringArr);
            get4Numbers(x, s);
        }

        public static int[] getIntegerArrayList(String[] stringArr) {
            int[] ret = new int[stringArr.length];
            for (int i = 0; i < stringArr.length; i++) {
                ret[i] = (Integer.parseInt(stringArr[i]));
            }

            return ret;
        }

        public static void get4Numbers(int a[],int sum){

            int len=a.length;

            Map<Integer, Pair> sums = new HashMap<Integer, Pair>();
            for (int i = 0; i < len; ++i) {
                // 'sums' hastable holds all possible sums a[k] + a[l]
                // where k and l are both less than i

                for (int j = i + 1; j < len; ++j) {
                    int current = a[i] + a[j];
                    int rest = sum - current;
                    // Now we need to find if there're different numbers k and l
                    // such that a[k] + a[l] == rest and k < i and l < i
                    // but we have 'sums' hashtable prepared for that
                    if (sums.containsKey(rest)) {
                        // found it
                        Pair p = sums.get(rest);
                        System.out.println(a[i]+" + "+a[j]+" + "+a[p.i] +" + "+a[p.j]+" = "+sum);

                    }
                }

                // now let put in 'sums' hashtable all possible sums
                // a[i] + a[k] where k < i
                for (int k = 0; k < i; ++k) {
                    sums.put(a[i] + a[k], new Pair(i, k));
                }
            }
        }
    }
