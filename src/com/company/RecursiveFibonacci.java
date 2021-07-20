    package com.company;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public class RecursiveFibonacci {
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int n = Integer.parseInt(reader.readLine());
            if (n < 0 || n > 32) {
                throw new Exception();
            }
            System.out.print(getInternCommits(n));
        }

        private static int getInternCommits(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            return getInternCommits(n - 1) + getInternCommits(n - 2);
        }
    }
