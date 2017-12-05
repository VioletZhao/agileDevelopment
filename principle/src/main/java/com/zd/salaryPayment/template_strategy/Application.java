package com.zd.salaryPayment.template_strategy;

/**
 * 将通用方法封装成一个抽象基类中去
 * 描述一个通用的主循环应用程序
 * Created by ZD on 2017/10/23.
 */
public abstract class Application {
    private boolean isDone = false;

    protected abstract void init();
    protected abstract void idle();
    protected abstract void cleanup();

    protected void setDone(){
        isDone = true;
    }

    protected boolean done(){
        return isDone;
    }

    public void run(){
        init();
        while (!done()){
            idle();
        }
        cleanup();
    }
}
