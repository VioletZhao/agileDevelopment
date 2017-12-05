package com.zd.salaryPayment.template_strategy;

/**
 * Created by ZD on 2017/10/23.
 */
public interface SortHandle {
    public void swap(int index);
    public boolean outOfOrder(int index);
    public int length();
    public void setArray(Object array);
}
