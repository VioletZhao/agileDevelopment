package basemodel.template_strategy;

/**
 * 滥用模式--将冒泡排序算法分离出来，
 * Created by ZD on 2017/10/23.
 */
public abstract class BubbleSorterBase {
    private int operations = 0;
    protected int length = 0;

    protected int doSort(){
        operations = 0;
        if (length <= 1)
            return operations;
        for (int nextToLast = length - 2; nextToLast >= 0; nextToLast--)
            for (int index = 0; index <= nextToLast; index++){
                if (outOfOrder(index))
                    swap(index);
                operations++;
            }
            return operations;
    }

    protected abstract void swap(int index);

    protected abstract boolean outOfOrder(int index);
}
