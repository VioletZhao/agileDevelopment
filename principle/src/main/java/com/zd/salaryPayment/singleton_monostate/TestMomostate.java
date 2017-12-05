package com.zd.salaryPayment.singleton_monostate;

import junit.framework.TestCase;

/**
 * Created by ZD on 2017/10/23.
 */
public class TestMomostate extends TestCase {

    public TestMomostate(String name){
        super(name);
    }

    public void testInstance(){
        Monostate m = new Monostate();
        for (int x = 0; x < 10; x++){
            m.setX(x);
            assertEquals(x,m.getX());
        }
    }

    public void testInstanceBehaveAsOne(){
        Monostate m1 = new Monostate();
        Monostate m2 = new Monostate();
        for (int x = 0; x < 10; x++){
            m1.setX(x);
            assertEquals(x,m2.getX());
        }
    }

}
