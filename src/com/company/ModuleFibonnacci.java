    package com.company;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;

    public class ModuleFibonnacci {
        public static void main(String[] args) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String[] numbers = reader.readLine().trim().split("\\s+");
            int n = Integer.parseInt(numbers[0]);
            if (n < 0 || n > 1000000) {
                throw new Exception();
            }
            int k = Integer.parseInt(numbers[1]);
            if (k < 1 || k > 8) {
                throw new Exception();
            }
            int internCommits = getInternCommits(n);
            int internCommitsDigits = (int)(Math.log10(n) + 1);
            if (internCommitsDigits < k) {
                System.out.print(internCommits);
            }
            else {
                System.out.print(getKSymbols(internCommits, k));
            }
        }
        private static int getInternCommits(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int previous = -1;
            int result = 1;

            for (int i = 0; i <= n; i++) {
                int sum = result + previous;
                previous = result;
                result = sum;
            }

            return result;
        }
        private static int getKSymbols(int commits, int k) {
            return (int) (commits % Math.pow(10, k));
        }
    }
