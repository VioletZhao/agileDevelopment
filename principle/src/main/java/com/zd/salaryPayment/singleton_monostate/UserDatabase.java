package com.zd.salaryPayment.singleton_monostate;

/**
 * 包含有读写user对象的方法，这些方法通过调用第三方数据库api，并执行user对象和数据库的表，行之间的转换工作
 * Created by ZD on 2017/10/23.
 */
public interface UserDatabase {

    User readUser(String userName);
    void writeUser(User user);
}
