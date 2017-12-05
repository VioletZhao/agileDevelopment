package com.zd.salaryPayment.template_strategy;

/**
 * Created by ZD on 2017/10/23.
 */
public class IntSortBubble implements SortHandle {

    private int[] array = null;

    public void swap(int index) {
        int temp = array[index];
        array[index] = array[index+1];
        array[index+1] = temp;
    }

    public boolean outOfOrder(int index) {
        return (array[index] > array[index+1]);
    }

    public int length() {
        return array.length;
    }

    public void setArray(Object array) {
        this.array = (int[]) array;
    }
}
