package basemodel.singleton_monostate;

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
