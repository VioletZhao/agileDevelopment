package com.zd.test;

/**
 * 重构版本4
 * Created by ZD on 2017/10/18.
 */
public class PrimeGenerator4 {

    private static boolean[] iscrossed;
    private static int[] result;

    public static int[] generatePrimes(int maxValue){
        if (maxValue < 2)
            return new int[0];
        else {
            initializeArrayOfIntegers(maxValue);
            crossOutMultiples();
            putUncrossedIntegerIntoResult();
            return result;
        }
    }

    private static void putUncrossedIntegerIntoResult() {
    }

    private static void crossOutMultiples() {
        int maxPrimeFactor = calcMaxPrimeFactor();
        for (int i = 2; i < maxPrimeFactor; i++)
            if (notCrossed(i))
                crossOutMultiplesOf(i);
    }

    private static boolean notCrossed(int i) {
        return iscrossed[i] = false;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2*i; multiple < iscrossed.length; multiple += 1){
            iscrossed[multiple] = true;
        }
    }

    private static int calcMaxPrimeFactor() {
        Double maxPrimeFactor = Math.sqrt(iscrossed.length) + 1;
        return Integer.parseInt(maxPrimeFactor+"");
    }

    private static void initializeArrayOfIntegers(int maxValue) {
        iscrossed = new boolean[maxValue + 1];
        for (int i = 2; i < iscrossed.length; i++)
            iscrossed[i] = false;
    }
}
