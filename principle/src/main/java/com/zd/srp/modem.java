package com.zd.srp;

/**
 * 违反单一职责原则
 * 这里涉及到俩个职责，一个是连接modem，一个是数据通信
 * 如果连接modem需要变化，那么调用send和recv的类必须重新编译
 *
 *
 * Created by ZD on 2017/10/19.
 */
public interface modem {

    public void dail(String pno);
    public void hangup();
    public void send(char c);
    public void recv();

}
