package basemodel.template_strategy;

/**
 * 使用策略模式来排序
 * Created by ZD on 2017/10/23.
 */
public class BubbleSorter1 {

    private int operations = 0;
    private int length = 0;
    private SortHandle itSortHandle = null;

    public BubbleSorter1(SortHandle handle){
        itSortHandle = handle;
    }

    public int sort(Object array){
        itSortHandle.setArray(array);
        length = itSortHandle.length();
        operations = 0;
        if (length <= 1)
            return operations;

        for (int nextToLast = length - 2;nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++){
                if (itSortHandle.outOfOrder(index))
                    itSortHandle.swap(index);
                operations++;
            }
            return operations;
    }
}
