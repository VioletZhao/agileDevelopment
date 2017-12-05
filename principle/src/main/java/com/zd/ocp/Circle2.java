package com.zd.ocp;

import java.util.Iterator;
import java.util.Vector;

/**
 * Created by ZD on 2017/10/19.
 */
public class Circle2 implements Shape2 {
    public void draw() {
        System.out.println("circle draw");
        Vector vector = new Vector();
        Iterator iterator = (Iterator) vector;
        while (iterator.hasNext()){
            iterator.next().draw();
        }
    }

}
