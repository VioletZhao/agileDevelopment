package com.zd.ocp;

import java.awt.*;


/**
 * 在一个标准的GUI上绘制圆和正方形的程序
 * Created by ZD on 2017/10/19.
 */
enum shapeTYpe{circle,square};


public class Shape {
    shapeTYpe itsType;
}

class Circle{
    shapeTYpe itType;
    double itsRadius;
    Point itsCenter;
}

class Square{
    shapeTYpe iysType;
    double itsSide;
    Point itsTopLeft;
}

class ShapePointer{
    void drawAllShapes(ShapePointer[] list,int n){
        int i;
        for (i = 0; i < n; i++){
            switch (list[i]){
                case square:
                    drawSquare();
                    break;
                case circle:
                    drawCircle();
                    break;
            }
        }
    }
}
