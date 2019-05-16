package com.tsu.zqy.guavaTest;


import com.google.common.base.Charsets;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multimap;
import com.google.common.hash.Hashing;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Ints;
import org.junit.Test;

import java.util.Arrays;

/**
 * @ClassName Test1
 * @Author Elv1s
 * @Date 2019/5/3 9:02
 * @Description:
 */
public class Test1 {

    @Test
    public void test1() {
        HashMultiset<String> multiset = HashMultiset.create();
        multiset.add("111");
        multiset.add("2222");
        multiset.add("444", 5);

        System.out.println(multiset);   //[111, 444 x 5, 2222]
        System.out.println(multiset.elementSet());  //[111, 444, 2222]
        System.out.println(multiset.count("111")); // 1
        System.out.println(multiset.count("444")); // 5
        System.out.println(multiset.count("000")); // 0
        System.out.println(multiset.containsAll(Arrays.asList("111", "2222"))); //true
        System.out.println(multiset.containsAll(Arrays.asList("111", "2222", "3"))); //false
    }

    @Test
    public void test2() {
        Multimap<String, Integer> multimap = ArrayListMultimap.create();
        multimap.put("a", 1);
        multimap.put("a", 2);
        multimap.put("a", 4);
        multimap.put("b", 3);
        multimap.put("c", 5);

        System.out.println(multimap);
        System.out.println(multimap.keys());//[a x 3, b, c]
        System.out.println(multimap.get("a"));//[1 ,2, 4]
        System.out.println(multimap.get("b"));//[3]
        System.out.println(multimap.get("c"));//[5]
        System.out.println(multimap.get("d"));//[]

        System.out.println(multimap.asMap());//{a=[1, 2, 4], b=[3], c=[5]}
    }

    @Test
    public void test3() {
        System.out.println(Ints.asList(1, 2, 3, 4));
        System.out.println(Ints.compare(43, 2));
        System.out.println(Ints.join("-", 1, 2, 3, 4));
        System.out.println(Ints.join(",", 1, 2, 3, 4));
        System.out.println(Ints.max(1, 3, 5, 4, 6));
        System.out.println(Ints.tryParse("1234"));

        System.out.println(Booleans.asList(true, true, false));
        System.out.println(Booleans.compare(false, true));
        System.out.println(Booleans.join(",", true, true, false));
    }

    @Test
    public void test4() {
        String str = "hello world!";
        String s = Hashing.md5().newHasher()
                .putString(str, Charsets.UTF_8)
                .hash()
                .toString();
        String s1 = Hashing.md5().newHasher(2).hash().toString();
        System.out.println(s);
        System.out.println(s1);
    }
}


