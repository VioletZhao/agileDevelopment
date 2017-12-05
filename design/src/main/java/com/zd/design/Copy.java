package com.zd.design;

/**
 * 应对不断变化的需求，该如何设计程序
 * 开放封闭原则---无需修改设计即可扩展的模块；出现同类时该如何操作
 * Created by ZD on 2017/10/19.
 */
public class Copy {
    Reader reader = new KeyboardReader();

    public void copy(){
        reader.read();
    }
}

abstract class Reader{
    public abstract void read();
}

class KeyboardReader extends Reader{
    public void read() {

    }
}

