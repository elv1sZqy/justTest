package com.tsu.zqy.HashMap;

/**
 * @InterfaceName MyMap
 * @Author Elv1s
 * @Date 2019/5/17 16:22
 * @Description:
 */

public interface MyMap<K,V> {
    /**
     * 存数据
     * @param k
     * @param v
     * @return
     */
    V put(K k, V v);

    /**
     * 读数据
     * @param v
     * @return
     */
    V get(K v);

    interface Entry<K,V>{
        K getkey();
        V getValue();
    }
}
