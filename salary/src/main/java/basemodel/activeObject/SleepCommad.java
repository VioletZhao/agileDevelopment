package basemodel.activeObject;

/**检查以前是否执行过，如果没有，就记录下开始时间，如果没有过延迟时间，就把自己加到activeObjectEngine中，如果过了
 * 延迟时间，就把wakeup命令对象加入到引擎中去
 * Created by ZD on 2017/10/23.
 */
public class SleepCommad implements Command{

    private Command wakeupCommand = null;
    private ActiveObjectEngine engines = null;
    private long sleepTime = 0;
    private long startTime = 0;
    private boolean started = false;




    public SleepCommad(long mileSeconds,ActiveObjectEngine e, Command wakeup) {
        sleepTime = mileSeconds;
        engines = e;
        this.wakeupCommand = wakeup;
    }

    public void execute() throws Exception {
        long currentTime = System.currentTimeMillis();
        if (!started){
            started = true;
            startTime = currentTime;
            engines.addCommand(this);

        }else if ((currentTime - startTime) < startTime ) {
            engines.addCommand(this);

        }
        else {
            engines.addCommand(wakeupCommand);

        }
    }
}
