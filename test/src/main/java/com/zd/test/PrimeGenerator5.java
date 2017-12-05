package com.zd.test;

/**
 * Created by ZD on 2017/10/18.
 */
public class PrimeGenerator5 {

    private static boolean[] crossedOut;
    private static int[] result;

    public static int[] generatePrimes(int maxValue){
        if (maxValue < 2)
            return new int[0];
        else {
            uncrossIntegerUpTo(maxValue);
            crossOutMultiples();
            putUncrossedIntegersIntoResult();
            return result;
        }
    }

    private static void crossOutMultiples() {
        int limit = determineINterationLimit();
        for (int i = 2; i <= limit; i++)
            if (notCrossed(i))
                crossOutMultiplesOf(i);
    }

    private static boolean notCrossed(int i) {
        return crossedOut[i] == false;
    }

    private static void crossOutMultiplesOf(int i) {
        for (int multiple = 2*i; multiple < crossedOut.length; multiple+= i)
            crossedOut[multiple] = true;
    }

    private static int determineINterationLimit() {
        double iterationLimit = Math.sqrt(crossedOut.length);
        return (int) iterationLimit;
    }

    private static void putUncrossedIntegersIntoResult() {
        result = new int[numberIfUncrossedIntegers()];
        for (int j = 0,i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                result[j++] = i;
    }

    private static int numberIfUncrossedIntegers() {
        int count = 0;
        for (int i = 2; i < crossedOut.length; i++)
            if (notCrossed(i))
                count++;
        return count;
    }

    private static void uncrossIntegerUpTo(int maxValue) {
        crossedOut = new boolean[maxValue + 1];
        for (int i = 2; i < crossedOut.length; i++)
            crossedOut[i] = false;
    }

}
