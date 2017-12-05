/**
 * Created by ZD on 2017/10/23.
 */
package com.zd.salaryPayment.activeObject;

/*
*1.ActiveObjectEngine:维护Command对象的链表，用户可以向该引擎增加新的命令，或者调用run()
*
*RTC（run-to-completion）任务去构建多线程系统；共享同个运行时堆栈，不像多线程中，会为每个线程
* 分配运行时堆栈，在需要大量线程的内存受限系统中是一个强大的优势。
 */