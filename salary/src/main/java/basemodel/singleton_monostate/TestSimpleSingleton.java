package basemodel.singleton_monostate;

import junit.framework.TestCase;

import java.lang.reflect.Constructor;

/**
 * Created by ZD on 2017/10/23.
 */
public class TestSimpleSingleton extends TestCase {

    public TestSimpleSingleton(String name){
        super(name);
    }

    public void testCreateSingleton(){
//        Singleton s = Singleton.Instance();
//        Singleton s2 = Singleton.Instance();
//        assertSame(s,s2);
    }

    /**
     * 没有构造函数，Class.forName()是通过调用调用默认构造函数实现的
     * @throws ClassNotFoundException
     */
    public void testNoPublicConstructors() throws ClassNotFoundException {
        Class singleton = Class.forName("com.zd.salaryPayment.singleton_monostate.Singleton");
        Constructor[] constructors = singleton.getConstructors();
        assertEquals("Singleton has public constructors ",0,constructors.length);
    }
}
