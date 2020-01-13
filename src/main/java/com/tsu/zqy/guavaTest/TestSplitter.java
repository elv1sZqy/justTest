package com.tsu.zqy.guavaTest;

import com.google.common.base.Objects;
import com.google.common.base.Splitter;
import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * @author zhuQiYun
 * @create 2019/12/4
 * @description :
 */
public class TestSplitter {

    @Test
    public void testSplitter(){
        List<String> list = Splitter.on("#@#").splitToList("ni#hao#a");
        Assert.assertNotNull(list);
        Assert.assertEquals(list.size(),3);
        Assert.assertEquals(list.get(1),"hao");
        // 可以忽略空值
        List<String> list2 = Splitter.on("#").omitEmptyStrings().splitToList("ni#hao#a###");
        Assert.assertEquals(list2.size(),3);

        List<String> list1 = Splitter.fixedLength(3).splitToList("123321789");
        Assert.assertEquals("321",list1.get(1));


        List<String> list3 = Splitter.on("#").limit(3).splitToList("1#2#3#4#5");
        Assert.assertEquals(list3.size(),3);
        System.out.println(list3.get(2));
        Assert.assertEquals(list3.get(2),"3#4#5");
    }
}
