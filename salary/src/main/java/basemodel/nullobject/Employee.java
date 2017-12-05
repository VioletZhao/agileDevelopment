package basemodel.nullobject;

import java.util.Date;

/**
 * 使无效雇员成为一个匿名内嵌类是一种确保该类只有单一实例的方法
 * Created by ZD on 2017/10/23.
 */
public interface Employee {
    public boolean isTimeToPay(Date payDate);

    public void pay();

    public static final Employee NULL = new Employee() {
        public boolean isTimeToPay(Date payDate) {
            return false;
        }

        public void pay() {

        }
    };
}
