package basemodel.singleton_monostate;

/**
 * Created by ZD on 2017/10/23.
 */
public class TurnStile {

    private static boolean isLocked = true;
    private static boolean isAlarming = false;
    private static int itsCoins = 0;
    private static int itsRefunds = 0;
    protected final static TurnStile LOCKED = new Locked();
    protected final static TurnStile UNLOCKED = new Unlocked();
    protected static TurnStile itsState = LOCKED;

    public void reset(){
        lock(true);
        alarm(false);
        itsCoins = 0;
        itsRefunds = 0;
        itsState = LOCKED;
    }

    public boolean locked(){
        return isLocked;
    }

    public boolean alarm(){
        return isAlarming;
    }

    public void coin(){
        itsState.coin();
    }

    public void pass(){
        itsState.pass();
    }

    protected void lock(boolean shouldLock){
        isLocked = shouldLock;
    }

    protected void alarm(boolean shouldAlarm){
        isAlarming = shouldAlarm;
    }

    public int coins(){
        return itsCoins;
    }

    public int refunds(){
        return itsRefunds;
    }

    public void deposit(){
        itsCoins++;
    }

    public void refund(){
        itsRefunds++;
    }


    private static class Locked extends TurnStile {
        public void coin(){
            itsState = UNLOCKED;
            lock(false);
            alarm(false);
            deposit();
        }
        public void pass(){
            alarm(true);
        }
    }

    private static class Unlocked extends TurnStile {
        public void coin(){
            refund();
        }
        public void pass(){
            lock(true);
            itsState = LOCKED;
        }
    }
}
