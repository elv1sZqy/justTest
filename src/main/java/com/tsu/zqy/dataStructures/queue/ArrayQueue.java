package com.tsu.zqy.dataStructures.queue;

import java.util.Scanner;

/**
 * @ClassName ArrayQueue
 * @Author Elv1s
 * @Date 2019/7/10 16:31
 * @Description:
 */
public class ArrayQueue {

    public static void main(String[] args) {
        Queue queue = new SimpleQueue(3);
        testFunction(queue);
    }

    /**
     * 测试方法
     * @param queue
     */
    public  static void testFunction(Queue queue) {
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        //true 就循环, false 就退出
        boolean loop = true;

        while (loop) {
            System.out.println("a  添加");
            System.out.println("h  显示头");
            System.out.println("p  取出头");
            System.out.println("s  展示所有");
            System.out.println("e  退出");

            //输入的第一个字符
            key = scanner.next().charAt(0);
            switch (key) {
                case 'a':
                    System.out.println("输入一个数:");
                    int i = scanner.nextInt();
                    queue.addQueue(i);
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                case 's':
                    queue.showQueue();
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                case 'p':
                    System.out.println(queue.popQueue());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                case 'h':
                    System.out.println(queue.peekQueue());
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    break;
                case 'e':
                    loop = false;
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                    System.out.println("已退出");
                default:

            }
        }
    }
}

class SimpleQueue implements Queue{
    /**
     * 头指针
     */
    private int front;
    /**
     * 尾指针
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

    public SimpleQueue(int maxSize) {
        this.maxSize = maxSize;
        array = new int[maxSize];
        front = -1;
        rear = -1;
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
     *
     * @return
     */
    @Override
    public boolean isFull() {
        return rear == maxSize - 1;
    }

    /**
     * 添加数据
     *
     * @param data
     * @return
     */
    @Override
    public boolean addQueue(int data) {
        // 如果为空, 就抛出异常
        if (isFull()) {
            throw new RuntimeException("队列已经满了");
        }
        //不为空就不抛出异常
        else {
            rear++;
            array[rear] = data;
            return true;
        }
    }

    /**
     * 取出队列头数据
     *
     * @return
     */
    @Override
    public int popQueue() {
        //如果为空就抛出异常
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            front++;
            return array[front];
        }
    }

    /**
     * 展示队列头数据, 不取出
     *
     * @return
     */
    @Override
    public int peekQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列为空");
        } else {
            return array[front + 1];
        }
    }

    /**
     * 展示队列
     */
    @Override
    public void showQueue() {
        for (int i = front; i < array.length; i++) {
            System.out.printf("%d\n", array[i]);
        }
    }
}
