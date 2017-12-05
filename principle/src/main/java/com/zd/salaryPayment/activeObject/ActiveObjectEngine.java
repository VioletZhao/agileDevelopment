package com.zd.salaryPayment.activeObject;

import java.util.LinkedList;

/**
 * 维护Command对象的链表
 * Created by ZD on 2017/10/23.
 */
public class ActiveObjectEngine {

    LinkedList itsCommands = new LinkedList();

    /*
    *增加command
     */
    public void addCommand(Command c){
        itsCommands.add(c);
    }

    public void run() throws Exception {
        while (!itsCommands.isEmpty()){
            Command c = (Command) itsCommands.getFirst();
            itsCommands.removeFirst();
            c.execute();
        }
    }


}
