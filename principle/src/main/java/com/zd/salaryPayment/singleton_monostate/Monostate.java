package com.zd.salaryPayment.singleton_monostate;

/**
 * Created by ZD on 2017/10/23.
 */
public class Monostate {

    private static int itsX = 0;

    public Monostate(){}

    public static int getX() {
        return itsX;
    }

    public static void setX(int itsX) {
        Monostate.itsX = itsX;
    }
}
