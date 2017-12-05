package com.zd.salaryPayment.activeObject;

/**
 * 使用SleepCommnad展示多线程行为
 * Created by ZD on 2017/10/23.
 */
public class DelayedTyper implements Command {

    private long itsDelay;
    private char itsChar;
    private static ActiveObjectEngine engine = new ActiveObjectEngine();
    private static boolean stop = false;

    public static void main(String[] args) throws Exception {
        engine.addCommand(new DelayedTyper(100, '1'));
        engine.addCommand(new DelayedTyper(300, '3'));
        engine.addCommand(new DelayedTyper(500, '5'));
        engine.addCommand(new DelayedTyper(700, '7'));


        Command stopCommand = new Command() {
            public void execute() throws Exception {
                stop = true;
            }
        };

        engine.addCommand(new SleepCommad(20000,engine,stopCommand));
        engine.run();

    }

    public DelayedTyper(long delay,char c){
        itsDelay = delay;
        itsChar = c;
    }


    public void execute() throws Exception {
        System.out.println(itsChar);
        if (!stop){
            delayAndRepeat();
        }
    }

    private void delayAndRepeat() {
        engine.addCommand(new SleepCommad(itsDelay,engine,this));
    }
}

