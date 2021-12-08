package com.tsu.zqy.test;

import com.google.common.collect.Lists;
import lombok.Data;
import org.junit.Test;

import java.util.*;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName Test1
 * @Author Elv1s
 * @Date 2021/12/8 16:07
 * @Description: 有一个集合 , 里面有很多字符串, 字符串中一旦数字串相同就代表他们是同一个元素,
 */
public class Test1 {


    @Test
    public void test() {
        List<String> list = new ArrayList();
        list.add("1231dfgh");
        list.add("1234dfgh");
        list.add("123dfgh");
        list.add("1235gfddfgh");
        list.add("1234gfddfgh");
        list.add("gfddfgh");
        list.add("gfddfgh1234");
        List<String> list1 = removeSameStr(list);
        System.out.println(list1);
    }

    /**
     * 暂定  看看能不能优化
     *
     * @param list
     * @return
     */
    public List<String> removeSameStr(List<String> list) {
        List<String> result = new ArrayList<>(list.size());
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            char[] chars = list.get(i).toCharArray();
            StringBuilder builder = new StringBuilder();
            for (char aChar : chars) {
                // 只会有一个数字串
                if (aChar >= 48 && aChar <= 57) {
                    builder.append(aChar);
                }
            }
            map.put(builder.toString(), i);
        }
        map.forEach((s, index) -> {
            result.add(list.get(index));
        });
        return result;
    }


    @Test
    public void test2() {
        Department department = new Department(1, "学校");
        Department department1 = new Department(2, "语文");
        Department department2 = new Department(3, "数学");
        Department department3 = new Department(4, "语文");
        List<Department> child = new ArrayList<>();
        child.add(department1);
        child.add(department3);
        child.add(department2);
        department.setChildren(child);
        Department department4 = new Department(5, "语文");
        List<Department> child2 = new ArrayList<>();
        child2.add(department4);
        department2.setChildren(child2);
        System.out.println(findSameDepartMentId(department, "语文"));
    }

    /**
     * 递归遍历.
     *
     * @param departMent root部门
     * @param name       需要寻找的部分名称   名称会不会为空..
     * @return
     */
    public List<Integer> findSameDepartMentId(Department departMent, String name) {
        List<Integer> result = new ArrayList<>();
        doFind(result, departMent, name);
        return result;
    }

    private void doFind(List<Integer> result, Department departMent, String name) {
        // 基本不会为空, 做一下校验
        if (departMent == null) {
            return;
        }
        // 比较当前部门
        if (name.equals(departMent.getName())) {
            result.add(departMent.getId());
        }
        // 比较当前部门的子部门
        List<Department> children = departMent.getChildren();
        if (children != null && children.size() > 0) {
            for (Department child : children) {
                doFind(result, child, name);
            }
        }
    }

    @Data
    private class Department {
        private Integer id;
        private String name;
        private List<Department> children;

        public Department() {
        }

        public Department(Integer id, String name) {
            this.id = id;
            this.name = name;
        }
    }


    private static ReentrantLock lock = new ReentrantLock();
    private static Condition conditionA = lock.newCondition();
    private static Condition conditionB = lock.newCondition();
    private static Condition conditionC = lock.newCondition();

    private static volatile int times = 0;

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                printlStr("A", 0, conditionA, conditionB);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "printA").start();
        new Thread(() -> {
            try {
                printlStr("B", 1, conditionB, conditionC);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "printB").start();
        new Thread(() -> {
            try {
                printlStr("C", 2, conditionC, conditionA);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "printC").start();

    }


    public static void printlStr(String str, Integer index, Condition currentCondition, Condition nextCondition) throws InterruptedException {
        while (true) {
            lock.lock();
            if (times % 3 != index) {
                currentCondition.await();
            }
            // 一共10次循环 三个线程
            if (times >= 30) {
                nextCondition.signal();
                lock.unlock();
                return;
            }
            times++;
            System.out.println(str);
            nextCondition.signal();
            lock.unlock();

        }
    }

    @Test
    public void test3(){
        ArrayList<Integer> integers = Lists.newArrayList(1, 2, 3, 4, 5,100);
        ArrayList<Integer> integers1 = Lists.newArrayList(1, 5, 35, 65,102);
        ArrayList<Integer> integers2 = Lists.newArrayList(1, 5, 35, 70,50,95);
        List<List<Integer>> lists = new ArrayList<>();
        lists.add(integers);
        lists.add(integers1);
        lists.add(integers2);
        System.out.println(findTop10(lists));
    }


    /**
     * 数组中元素会不会重复...
     * @param nums
     * @return
     */
    private PriorityQueue<Integer> findTop10(List<List<Integer>> nums) {
        int currentMinNum = Integer.MIN_VALUE;
        PriorityQueue<Integer> queue = new PriorityQueue<>(10);
        List<Integer> result = new ArrayList<>();
        for (List<Integer> num : nums) {
            for (int i = num.size() - 1; i >= 0; i--) {
                Integer aNum = num.get(i);
                if (aNum > currentMinNum) {
                    queue.add(aNum);
                    if (queue.size() > 10) {
                        queue.poll();
                        currentMinNum = queue.peek();
                    }
                } else {
                    break;
                }
            }

        }
        return queue;
    }
}
