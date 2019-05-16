package com.tsu.zqy.jdk8.stream;

import com.tsu.zqy.jdk8.common.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @ClassName StreamTest
 * @Author Elv1s
 * @Date 2019/5/12 15:42
 * @Description:
 */
public class StreamTest {


    /**
     * 筛选与切片
     */
    @Test
    public void test1() {
        List<Integer> list = Arrays.asList(4, 3, 1, 6, 8, 2, 88, 33, 3, 222);
        //通过集合生成
        Stream<Integer> stream = list.stream();

        //数组
        int[] a = {1,4,4,5,6,7};
        IntStream stream1 = Arrays.stream(a);
        stream1.filter(integer -> integer < 5).forEach(System.out :: println);
        System.out.println("-------------------");

        /*//去重
        stream.distinct().forEach(System.out :: println);*/

       /* //过滤
        stream.filter(integer -> integer < 20).forEach(System.out ::println);*/

      /* //限制前五个
        stream.limit(5).forEach(System.out ::println);*/

        // 去除前两个
        stream.skip(2).forEach(System.out::println);
    }

    /**
     * 映射
     */
    @Test
    public void test2() {
        List<String> list = Arrays.asList("aaa", "bbb", "ccc", "dddd");

        //每个转大写
        list.stream().map(str -> str.toUpperCase()).forEach(System.out::println);

        //输出每个的长度
        list.stream().map(String::length).forEach(System.out::println);

        list.stream().map(s -> s.length() < 4 ? s : "")
                .forEach(System.out::println);

        List<User> list1 = User.getList();
        //过滤名字小于三的
        list1.stream().map(User::getName).filter(s -> s.length() > 3).forEach(System.out :: println);
    }

    /**
     * 排序
     *
     * sorted()自然排序
     *
     * sorted(com....)  定制排序
     */
    @Test
    public void test3(){

        //sorted()自然排序
        List<Integer> list = Arrays.asList(-99,4, 3, 1, 6, 8, 2, 88, 33, 3, 222);
        list.stream().sorted().forEach(System.out :: println);
        System.out.println("-------------------");

        User.getList().stream().map(User::getAge).sorted().forEach(System.out::println);

        User.getList().stream()
                //根据年龄升序排序
                //.sorted((o1, o2) -> o1.getAge().compareTo(o2.getAge()))
                //倒叙    加一个负号
                .sorted((o1, o2) -> - o1.getAge().compareTo(o2.getAge()))
                .forEach(System.out ::println);
    
    }
    //------------------------------终止操作------------------------------

    /**
     * 终止操作:
     *          1.匹配与查找
     *          2.归约
     *          3.收集
     *          
     */

    /**
     * 匹配与查找
     */
    @Test
    public void test5(){
        List<User> list = User.getList();

        //全部符合返回true
        System.out.println(list.stream().allMatch(user -> user.getAge() > 13));

        //只要有一个符合就返回true
        System.out.println(list.stream().anyMatch(user -> user.getAge() > 13));

        //一个都不符合就返回true
        System.out.println(list.stream().noneMatch(user -> user.getAge() < 9));

        //返回第一个
        System.out.println(list.stream().findFirst());

        //返回任意一个     (parallelStream 是并行流,之前的全是串行流)
        System.out.println(list.parallelStream().findAny());

        //最大值
        System.out.println(list.stream().max((o1, o2) -> Integer.compare(o1.getAge(), o2.getAge())));
    }

    /**
     * 归约
     */
    @Test
    public void test6(){
        List<Integer> list = Arrays.asList(-99,4, 3, 1, 6, 8, 2, 88, 33, 3, 222);
        //求和,   identity是 初始值
        System.out.println(list.stream().reduce(0, Integer::sum));

        List<User> userList = User.getList();
        System.out.println(userList.stream().map(User::getAge).reduce(Integer::sum));

    }

    /**
     * 收集
     */
    @Test
    public void test7(){
        List<User> list = User.getList();
        List<User> collect = list.stream().filter(user -> user.getAge() > 12).collect(Collectors.toList());
        System.out.println(collect);


    }
    
}
