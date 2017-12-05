import com.za.example.Game;
import junit.framework.TestCase;

/**
 * Frame给出分数、每次投掷倒的木瓶数、是否会全中或者补中
 * Created by ZD on 2017/10/18.
 */
public class TestFrame extends TestCase {

    private Game g;

    public void setUp(){
        g = new Game();
    }

    public TestFrame(String name){
        super(name);
    }


    public void testTwoThrowsNoMark(){
        //Game g = new Game();
        g.add(4);
        g.add(5);
        assertEquals(9,g.score());
        assertEquals(1,g.getCurrentFrame());
    }

    /**
     * 没有补中和全中情况
     */
    public void testFourThrowsNoWork(){
        //Game g = new Game();
        g.add(3);
        g.add(4);
        g.add(7);
        g.add(1);
        assertEquals(15,g.score());
        assertEquals(7,g.scoreForFrame(1));
        assertEquals(15,g.scoreForFrame(2));
        assertEquals(3,g.getCurrentFrame());
    }

    /**
     * 补中情况
     */
    public void testSimpleSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        //g.add(2);
        assertEquals(13,g.scoreForFrame(1));
        assertEquals(2,g.getCurrentFrame());
        System.out.println(g.score());
    }

    public void testSimpleFrameAfterSpare(){
        g.add(3);
        g.add(7);
        g.add(3);
        g.add(2);
        assertEquals(13,g.scoreForFrame(1));
        assertEquals(18,g.scoreForFrame(2));
        assertEquals(18,g.score());
        assertEquals(3,g.getCurrentFrame());

    }

    /**
     * 全中
     */
    public void test(){
        g.add(10);
        g.add(3);
        g.add(6);
        assertEquals(19,g.scoreForFrame(1));
        assertEquals(28,g.score());
        assertEquals(2,g.getCurrentFrame());
    }

    public void testPerfectGame(){
        for (int i = 0; i < 12; i++){
            g.add(10);
        }
        assertEquals(300,g.score());
        assertEquals(10,g.getCurrentFrame());
    }

    public void testEndOfArray(){
        for (int i = 0; i < 9; i++){
            g.add(0);
            g.add(0);
        }
        g.add(2);
        g.add(8);
        g.add(10);
        assertEquals(20,g.score());
    }

    public void testSampleGame(){
        g.add(1);
        g.add(4);
        g.add(4);
        g.add(5);
        g.add(6);
        g.add(4);
        g.add(5);
        g.add(5);
        g.add(10);
        g.add(0);
        g.add(1);
        g.add(7);
        g.add(3);
        g.add(6);
        g.add(4);
        g.add(10);
        g.add(2);
        g.add(8);
        g.add(6);
        assertEquals(133,g.score());
    }

}
