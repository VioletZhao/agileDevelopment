package com.zd.salaryPayment.activeObject;

import junit.framework.TestCase;
import junit.textui.TestRunner;

/**
 *
 * Created by ZD on 2017/10/23.
 */
public class TestSleepCommand extends TestCase {

    public static void main(String[] args){
        TestRunner.main(new String[]{"TestSleepCommand"});
    }

    public TestSleepCommand(String name){
        super(name);
    }

    public boolean commandExecuted = false;

    public void testSleep() throws Exception {
        Command wakeup = new Command() {
            public void execute() throws Exception {
                commandExecuted = true;
            }
        };
        ActiveObjectEngine e = new ActiveObjectEngine();
        SleepCommad c = new SleepCommad(1000,e,wakeup);//延迟毫秒数、引擎对象、wakeup命令对象
        e.addCommand(c);
        long start = System.currentTimeMillis();
        e.run();
        long stop = System.currentTimeMillis();
        long sleepTime = stop - start;




    }

}
