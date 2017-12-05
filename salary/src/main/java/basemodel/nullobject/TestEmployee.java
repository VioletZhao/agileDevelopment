package basemodel.nullobject;

import junit.framework.TestCase;

import java.util.Date;

/**
 * Created by ZD on 2017/10/23.
 */
public class TestEmployee extends TestCase {
    public void testNull(){
        Employee e = DB.getEmployee("Bob");
        if (e.isTimeToPay(new Date())){
            fail();
        }
        assertEquals(Employee.NULL,e);

    }

}
