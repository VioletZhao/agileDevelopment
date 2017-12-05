package com.zd.salaryPayment.template_strategy;

/**
 * Created by ZD on 2017/10/23.
 */
public interface Application1 {

    public void init();
    public void idle();
    public void cleanup();
    public boolean done();
}
