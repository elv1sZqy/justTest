package com.tsu.zqy.HashMap;

/**
 * @ClassName MyHashMap
 * @Author Elv1s
 * @Date 2019/5/17 16:25
 * @Description:
 */
public class MyHashMap<K, V> implements MyMap<K, V> {

    /**
     * hashMap由数组加链表组成(jdk8之前;  从jdk8开始,链表长度大于8,就开始使用红黑树,为了加快遍历)
     */
    private Entry<K, V>[] table = null;
    /**
     * 默认值为16
     */
    private  Integer defaultLength = 4;
    /**
     * 扩容因子:
     * currentSize / table.length = defauleLoad
     * 一旦达到这个因子, table 就会扩容,  一般都是扩大为原来的两倍
     */
    private final double defauleLoader = 0.75d;
    /**
     * 当前map中对象的个数
     */
    private int size;


    /**
     * 无参构造
     */
    public MyHashMap() {
        this.table = new Entry[defaultLength];
        this.size = 0;
    }

    /**
     * 如果到达阈值,就调整大小
     */
  /*  public void resize() {
        System.out.println("当前table的长度为: " + this.table.length);
        if ((double)(size / table.length) >= defauleLoader){
            int newLength = table.length * 2;
            this.defaultLength *= defaultLength;
            Entry[] newTable = new Entry[newLength];
            transfer(newTable);
        }
    }*/


  /*  void transfer(Entry[] newTable) {
        Entry<K, V>[] table = this.table;
        for(int i = 0; i < table.length; i++){
            newTable[i] =  table[i];
        }
        this.table = newTable;
    }*/

    /**
     * put方法
     *
     * @param k
     * @param v
     * @return
     */
    @Override
    public V put(K k, V v) {
        int hash = hash(k);

        //判断当前hash下有没有值
        Entry<K, V> entry = table[hash];
        Entry<K, V> newEntry = null;
        //第一个值
        if (entry == null) {
            //k,v  next =null
            table[hash] = addEntry(hash, k, v, null);

            size++;

            //resize();

        }
        //已经存在值
        else {
            //将新的entry添加到当前角标下链表的最后一位
            newEntry = setNextEntry(hash, k, v, entry);

        }
        return newEntry == null ? table[hash].getValue() : newEntry.getValue();
    }

    /**
     * 为空的数组角标下添加第一个entry
     *
     * @param hash
     * @param k
     * @param v
     * @param entry
     * @return
     */
    private Entry addEntry(int hash, K k, V v, Entry entry) {
        return new Entry<>(k, v, null, hash);
    }

    /**
     * 如果之前已经存在值,  就使存在值的next指向当前entry
     *
     * @param hash
     * @param k
     * @param v
     * @param entry
     * @return
     */
    private Entry setNextEntry(int hash, K k, V v, Entry<K, V> entry) {
        Entry<K, V> newEntry = new Entry<>(k, v, null, hash);
        Entry e = getNullNext(entry);
        e.setNext(newEntry);
        return newEntry;
    }

    /**
     * 根据头结点获得尾节点
     *
     * @param entry
     * @return
     */
    private Entry getNullNext(Entry<K, V> entry) {
        while (entry.next != null) {
            entry = entry.next;
        }
        return entry;

    }

    /**
     * 通过k计算数组角标值
     *
     * @param k
     * @return
     */
    private int hash(K k) {
        //用hashCode 和  数组的长度 取余
        int index = k.hashCode() % (defaultLength);
        //会出现负数,所以取绝对值
        return Math.abs(index);
    }

    /**
     * 通过key获得对应entry的value
     *
     * @param k
     * @return
     */
    @Override
    public V get(K k) {
        Entry<K, V> e = getEntry(k);
        return e == null ? null : e.getValue();
    }

    /**
     * 通过k获取 对应的对象
     * @param k
     * @return
     */
    private Entry getEntry(K k) {
        int hash = hash(k);
        for (Entry e = table[hash]; e != null; e = e.next) {
            if (e.hash == hash && k == e.getkey() || k.equals(e.getkey())) {
                return e;
            }
        }
        return null;
    }


    /**
     * entry类
     * @param <K>
     * @param <V>
     */
    class Entry<K, V> implements MyMap.Entry<K, V> {

        private K k;
        private V v;
        private Entry<K, V> next;
        private Integer hash;

        public Entry<K, V> getNext() {
            return next;
        }

        public void setNext(Entry<K, V> next) {
            this.next = next;
        }

        public Entry(K k, V v, Entry<K, V> next, Integer hash) {
            this.k = k;
            this.v = v;
            this.next = next;
            this.hash = hash;
        }

        @Override
        public K getkey() {
            return k;
        }

        @Override
        public V getValue() {
            return v;
        }
    }
}
