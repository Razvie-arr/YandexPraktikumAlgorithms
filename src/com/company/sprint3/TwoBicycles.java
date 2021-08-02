package com.company.sprint3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TwoBicycles {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(reader.readLine());
        if (n < 1 || n > 1000000) {
            throw new Exception();
        }
        StringTokenizer moneys = new StringTokenizer(reader.readLine());
        int bicycleCost = Integer.parseInt(reader.readLine());
        if (bicycleCost > 1000000) {
            throw new Exception();
        }
        bicycleBuyProcess(n, moneys, bicycleCost);
    }

    private static void bicycleBuyProcess(int n, StringTokenizer moneys, int bicycleCost) throws Exception {
        int daysCounter = 0;
        int firstBicycle = -1;
        int secondBicycle = -1;
        int dayMoney;
        for (int i = 0; i < n; i++) {
            dayMoney = Integer.parseInt(moneys.nextToken());
            if (dayMoney < 0 || dayMoney > 1000000) {
                throw new Exception();
            }
            daysCounter++;
            if (dayMoney >= bicycleCost && firstBicycle == -1) {
                firstBicycle = daysCounter;
            }
            if (dayMoney >= bicycleCost * 2) {
                secondBicycle = daysCounter;
                break;
            }
        }

        System.out.print(firstBicycle + " " + secondBicycle);

    }
}
