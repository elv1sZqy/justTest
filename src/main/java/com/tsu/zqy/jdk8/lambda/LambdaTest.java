package com.tsu.zqy.jdk8.lambda;

import com.tsu.zqy.jdk8.common.User;
import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.*;

/**
 * @ClassName LambdaTest
 * @Author Elv1s
 * @Date 2019/5/12 14:42
 * @Description:
 */
public class LambdaTest {

    @Test
    public void test1() {

        //普通方式
        Runnable r = new Runnable() {

            @Override
            public void run() {
                System.out.println("执行方法");
            }
        };
        r.run();

        System.out.println("*******************************************");

        //lambda表达式方式

        Runnable r2 = () -> System.out.println("执行了方法");

        r2.run();

    }

    @Test
    public void test2() {
        Comparator<Integer> c = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(02);
            }
        };

        System.out.println(c.compare(1, 10));

        System.out.println("**************************");

        Comparator<Integer> comparator = (o1, o2) -> o1.compareTo(o2);
        Comparator<Integer> comparator2 = (o1, o2) -> Integer.compare(o1, o2);

        System.out.println(comparator.compare(10, 1));
        System.out.println(comparator2.compare(10, 100));

    }

    /*
    四大核心函数式接口
    1.消费型  Consumer<T>  void accept(T t)
    2.供给型  Supplier<T>  T get()
    3.函数型  Function<T,R> R apply(T t)
    4.断定型  Predicate<T>  boolean test(T t)
     */

    @Test
    public void test3() {
        //1.消费型  Consumer<T>  void accept(T t)
        Consumer<String> c = s -> System.out.println(s);
        c.accept("hello world");

    }

    @Test
    public void test4() {
        //2.供给型  Supplier<T>  T get()
        Supplier<String> supplier = () -> "nihao ";

        System.out.println(supplier.get());
    }

    @Test
    public void test5() {
        //3.函数型  Function<T,R> R apply(T t)
        Function<String, Integer> function = s -> s.length();

        System.out.println(function.apply("hello world"));
    }

    @Test
    public void test6() {
        //4.断定型  Predicate<T>  boolean test(T t)
        Predicate<Integer> predicate = integer -> integer >= 100;

        System.out.println(predicate.test(99));
    }

    //-----------------------方法引用------------------------------------


    @Test
    public void test7() {
        List<Integer> list = Arrays.asList(3, 4, 2, 6, 2, 3);

        list.forEach(System.out::println);

        User tom = new User("tom", 12);
        Supplier<String> supplier = tom::getName;
        System.out.println(supplier.get());

        Consumer<String> consumer = User :: eat;
        consumer.accept("西瓜");

        Supplier<User> userSupplier= User :: new;
        System.out.println(userSupplier.get());


        Function<String,User> userFunction = User ::new;

        User jason = userFunction.apply("jason");
        System.out.println(jason);

        BiFunction<String, Integer,User> user = User :: new;
        User jack = user.apply("jack", 19);
        System.out.println(jack);

    }

}


