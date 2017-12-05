package com.zd.test;

/**
 * 重构
 * Created by ZD on 2017/10/18.
 */
public class PrimeGenerator3 {

    private static boolean[] f;
    private static int[] result;

    public static int[] gengeratePrimes(int maxValue){
        if (maxValue < 2)
            return new int[0];
        else {
            initializeArrayIfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegerIntoResult();
            return result;
        }
    }

    private static void putUncrossedIntegerIntoResult() {
    }

    private static void crossOutMultiples() {
    }

    private static void initializeArrayIfIntegers(int maxValue) {
        f = new boolean[maxValue + 1];
        f[0] = f[1] = false;
        for (int i = 2; i < f.length; i++)
            f[i] = true;
    }
}
