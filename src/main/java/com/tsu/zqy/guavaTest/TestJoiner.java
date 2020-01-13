package com.tsu.zqy.guavaTest;

import com.google.common.base.Joiner;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/12/4
 * @description :
 */
public class TestJoiner {

    @org.junit.Test
    public void testJoiner(){
        List<Integer> list = Arrays.asList(2, 3, 4, 5, 6);
        List<Integer> listHasNull = Arrays.asList(2, 3, 4, 5, null);
        // 2#3#4#5#6  用 on中的元素分割集合
        // 如果存在null, 就会报空指针异常
        System.out.println(Joiner.on("#").join(list));
        // 2#3#4#5   忽略null值
        System.out.println(Joiner.on("#").skipNulls().join(listHasNull));
        // 2#3#4#5#默认值 用默认值代替null
        System.out.println(Joiner.on("#").useForNull("默认值").join(listHasNull));

        // 2#3#4#5#... 追加到sb
        StringBuilder sb = new StringBuilder();
        StringBuilder stringBuilder = Joiner.on("#").useForNull("...").appendTo(sb, listHasNull);
        System.out.println(stringBuilder.toString());


        ImmutableMap<String, String> map = ImmutableMap.of("key1", "v1", "key2", "v2");
        // key1value:v1# key2value:v2
        System.out.println(Joiner.on("# ").withKeyValueSeparator("value:").join(map));
    }

}
