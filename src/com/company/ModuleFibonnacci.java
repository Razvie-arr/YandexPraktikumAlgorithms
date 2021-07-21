    package com.company;

    import java.io.BufferedReader;
    import java.io.InputStreamReader;
    import java.math.BigInteger;

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
            BigInteger internCommits = getInternCommits(n);
            int internCommitsDigits = (int)(Math.log10(internCommits.doubleValue()) + 1);
            if (internCommitsDigits < k) {
                System.out.print(internCommits);
            }
            else {
                System.out.print(getKSymbols(internCommits, k));
            }
        }
        private static BigInteger getInternCommits(int n) {
            if (n == 0 || n == 1) {
                return BigInteger.valueOf(1);
            }
            BigInteger sum = BigInteger.valueOf(1);
            BigInteger prev = BigInteger.valueOf(1);

            for (int i = 1; i < n; i++) {
                sum = prev.add(sum);
                prev = sum.subtract(prev);
            }

            return sum;
        }
        private static BigInteger getKSymbols(BigInteger commits, int k) {
            BigInteger powedK = BigInteger.valueOf((long) Math.pow(10, k));
            return commits.mod(powedK);
        }
    }
