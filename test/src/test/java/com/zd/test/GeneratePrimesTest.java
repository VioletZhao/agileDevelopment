package com.zd.test;

import junit.framework.TestCase;
import junit.swingui.TestRunner;

/**
 * Created by ZD on 2017/10/18.
 */
public class GeneratePrimesTest extends TestCase {

    public static void main(String[] args){
        TestRunner.main(new String[]{"TestGeneratePrimes"});
    }

    public GeneratePrimesTest(String name){
        super(name);
    }

    public void testPrimes(){
        int[] nullArray = GeneratePrimes.gengeratePrimes(0);
        assertEquals(nullArray.length,0);

        int[] minArray = GeneratePrimes.gengeratePrimes(2);
        assertEquals(minArray.length,1);
        assertEquals(minArray[0],2);

        int[] threeArray = GeneratePrimes.gengeratePrimes(3);
        assertEquals(threeArray.length,2);
        assertEquals(threeArray[0],2);
        assertEquals(threeArray[1],3);

        int[] centArray = GeneratePrimes.gengeratePrimes(100);
        assertEquals(centArray.length,25);
        assertEquals(centArray[24],97);
    }
}