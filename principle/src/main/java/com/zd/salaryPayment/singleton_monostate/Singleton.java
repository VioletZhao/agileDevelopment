package com.zd.salaryPayment.singleton_monostate;

import com.sun.org.apache.bcel.internal.generic.IF_ACMPEQ;

/**
 * Created by ZD on 2017/10/23.
 */
public class Singleton {

//    public Singleton(String test){
//        System.out.println("test");
//    }

    public static Singleton theInstance = null;
    private Singleton(){};

    public static Singleton Instance() {
        if (theInstance == null){
            theInstance = new Singleton();
        }
        return theInstance;
    }
}
