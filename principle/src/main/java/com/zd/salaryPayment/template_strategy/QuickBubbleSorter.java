package com.zd.salaryPayment.template_strategy;

/**
 * 如果一个数组已经是按序排列的话，就提前结束
 * Created by ZD on 2017/10/23.
 */
public class QuickBubbleSorter {

    private int operations = 0;
    private int length = 0;
    private SortHandle itsSortHandle = null;

    public QuickBubbleSorter(SortHandle handle){
        itsSortHandle = handle;
    }

    public int sort(Object array){
        itsSortHandle.setArray(array);
        length = itsSortHandle.length();
        if (length <= 1)
            return operations;
        boolean thisPassInOrder = false;
        for (int nextToLast = length - 2;nextToLast >= 0 && thisPassInOrder;nextToLast--){
            thisPassInOrder = true;
            for (int index = 0; index <= nextToLast; index++){
                if (itsSortHandle.outOfOrder(index)){
                    itsSortHandle.swap(index);
                    thisPassInOrder = false;
                }
                operations++;
            }
        }
        return operations;
    }

}
