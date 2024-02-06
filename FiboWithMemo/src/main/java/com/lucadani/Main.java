package com.lucadani;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    static final int DIM_MAX = 1001;
    static double convertMillisToSeconds(long val) {
        return (double) val / 1000;
    }

    static long fibo(int n, List<Long> memoList) {
        if (n <= 1) {
            return n;
        }
        if (memoList.get(n) != -1) {
            return memoList.get(n);
        }
        var result = fibo(n - 1, memoList) + fibo(n - 2, memoList);
        memoList.set(n, result);
        return memoList.get(n);
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long startTime = System.currentTimeMillis();
        System.out.print("n = ");
        int n = scanner.nextInt();
        List<Long> memoList = new ArrayList<>(DIM_MAX);
        for (int i = 0; i < DIM_MAX; memoList.add((long) -1), ++i);
        long resultFibo = fibo(n, memoList);
        System.out.println("fibo(" + n + ") = " + resultFibo);
        long endTime = System.currentTimeMillis();
        double totalTimeInSeconds = convertMillisToSeconds(Math.abs(startTime - endTime));
        System.out.println("fibo(" + n + ") calculation took " + totalTimeInSeconds + " seconds");
    }
}