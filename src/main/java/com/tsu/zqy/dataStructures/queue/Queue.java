package com.tsu.zqy.dataStructures.queue;

/**
 * @InterfaceName Queue
 * @Author Elv1s
 * @Date 2019/7/13 9:05
 * @Description:
 *             队列的顶层接口
 */

public interface Queue {

    /**
     * 向队列里添加元素
     * @param i 添加的数据
     * @return 是否添加成功
     */
    boolean addQueue(int i);

    /**
     * 展示队列中的所有元素
     */
    void showQueue();

    /**
     * 取出队列的第一个元素
     * @return 队列的第一个元素
     */
    int popQueue();

    /**
     * 展示队列的第一个元素
     * @return 队列的第一个元素
     */
    int peekQueue();

    /**
     * 判断队列是否已经满
     * @return
     */
    boolean isFull();

    /**
     * 判断队列是否是空
     * @return
     */
    boolean isEmpty();
}
