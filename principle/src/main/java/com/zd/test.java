package com.zd;


import java.util.HashMap;

/**
 * Created by ZD on 2017/10/20.
 */
public class test {

    static HashMap maps = new HashMap();

     public static void main(String[] args){
        maps.put("1",2);
        maps.put("2",3);
        maps.put("2",4);
        System.out.println(maps);

    }
}
