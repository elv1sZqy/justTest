package com.tsu.zqy.dataStructures.queue;

/**
 * @ClassName CircleArrayQueue
 * @Author Elv1s
 * @Date 2019/7/10 16:31
 * @Description:
 */
public class CircleArrayQueue {

    public static void main(String[] args) {
        CircleQueue queue = new CircleQueue(3);

        //测试
        ArrayQueue.testFunction(queue);
    }
}

class CircleQueue implements Queue{
    /**
     * 头指针  第一个元素的下标
     */
    private int front;
    /**
     * 尾指针  最后一个元素的后一位
     */
    private int rear;
    /**
     * 数组
     */
    private int[] array;
    /**
     * 最大容量
     */
    private int maxSize;

    public CircleQueue(int maxSize) {
        this.maxSize = maxSize + 1;
        array = new int[this.maxSize];
        // rear 和 front 默认为0
    }

    /**
     * 判断是否为空
     *
     * @return
     */
    @Override
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 判断是否为满的
     * @return 是否满
     */
    @Override
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    @Override
    public boolean addQueue(int data) {
        // 如果为空, 就抛出异常
        if (isFull()) {
            System.out.println("队列已经满了");
            return false;
        }
        //不为空就添加元素
        else {
            array[rear] = data;
            rear = (rear + 1) % maxSize;
            return true;
        }
    }

    @Override
    public int popQueue() {
        //如果为空就抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            int result = array[front];
            front = (front + 1) % maxSize;
            return result;
        }
    }

    @Override
    public int peekQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return array[front];
        }
    }

    @Override
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("%d : %d\n", i % maxSize, array[i % maxSize]);
        }
    }

    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
