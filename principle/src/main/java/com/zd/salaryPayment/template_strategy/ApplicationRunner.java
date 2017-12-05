package com.zd.salaryPayment.template_strategy;

/**
 * Created by ZD on 2017/10/23.
 */
public class ApplicationRunner {

    private Application1 itsApplication = null;

    public ApplicationRunner(Application1 app){
        itsApplication = app;
    }
    public void run(){
        itsApplication.init();
        while (!itsApplication.done())
            itsApplication.idle();
        itsApplication.cleanup();
    }
}
