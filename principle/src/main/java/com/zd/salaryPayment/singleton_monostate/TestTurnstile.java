package com.zd.salaryPayment.singleton_monostate;

import junit.framework.TestCase;

/**
 * Created by ZD on 2017/10/23.
 */
public class TestTurnstile extends TestCase {

    public TestTurnstile(String name){
        super(name);
    }

    public void setUp(){
        TurnStile t = new TurnStile();
        t.reset();
    }

    public void testInit(){
        TurnStile t = new TurnStile();

    }

    public void testCoin(){
        TurnStile t = new TurnStile();
        t.coin();
        TurnStile t1 = new TurnStile();

    }

    public void testCoinAndPass(){
        TurnStile t = new TurnStile();
        t.coin();
        t.pass();

        TurnStile t1 = new TurnStile();
    }

    public void testTwoCoins(){
        TurnStile t = new TurnStile();
        t.coin();
        t.coin();

    }

    public  void testPass(){
        TurnStile t = new TurnStile();
        t.pass();
    }

    public void testCancelAlarm(){
        TurnStile t = new TurnStile();
        t.pass();
        t.coin();
    }

    public void testTwoOperations(){
        TurnStile t = new TurnStile();
        t.coin();
        t.pass();
        t.coin();

        t.pass();
    }

}
