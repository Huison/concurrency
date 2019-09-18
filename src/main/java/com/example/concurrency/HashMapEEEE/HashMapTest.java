package com.example.concurrency.HashMapEEEE;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

@Slf4j
public class HashMapTest {

    @Test
    public void woshinibaba(){
        HashMap<String,String> hashMap = new HashMap<String,String>();
        hashMap.put("李白","huison");
        int h = "李白".hashCode();
        log.info("李白.hashcode={}", "李白".hashCode());
        int a = h ^ (h >>> 16);
        log.info("hashcode异或={}", a);
        /**
         *  n为hashmap默认长度
         */
        int n = 1 >> 4;
        int index = (n - 1) & a;
        log.info("index={}", index);
        log.info("hash值转换为二进制={}", Integer.toBinaryString(a));
        log.info("散列函数测试{}","2".hashCode());
        /**
         *  0000 0000 0000 1100 1111 1000 1110 0011   850147
         *  &
         *  0000 0000 0000 0000 0000 0000 0000 1111   15
         *  =
         *  0000 0000 0000 0000 0000 0000 0000 0011   3
         *
         *  0000 0000 0000 0000 0000 0000 0001 0000   16
         */
         int tab[] = new int[16];
         int i;
         int hash = 1;
         int c = tab[i = (n - 1) & hash];


    }
}


/**
 *
 *      public V put(K key, V value) {
 *         return putVal(hash(key), key, value, false, true);
 *     }
 *
 *
 *     static final int hash(Object key) {
 *         int h;
 *         return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
 *     }
 *
 *
 *      final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
 *                    boolean evict) {
 *         Node<K,V>[] tab;
 *         Node<K,V> p;
 *         int n, i;
 *         //初始化
 *         if ((tab = table) == null || (n = tab.length) == 0)
 *             //数组的长度 默认为16
 *             n = (tab = resize()).length;
 *         //如果算出来的这个元素的位置是空的,就把这个键值对放在这个位置
 *         if ((p = tab[i = (n - 1) & hash]) == null)
 *             tab[i] = newNode(hash, key, value, null);
 *         //如果这个位置有元素
 *         else {
 *             Node<K,V> e; K k;
 *             //节点的key相同,直接覆盖节点
 *             if (p.hash == hash &&
 *                 ((k = p.key) == key || (key != null && key.equals(k))))
 *                 e = p;
 *             //判断该链为红黑树
 *             else if (p instanceof TreeNode)
 *                 //
 *                 e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
 *             else {
 *                 for (int binCount = 0; ; ++binCount) {
 *                     if ((e = p.next) == null) {
 *                         p.next = newNode(hash, key, value, null);
 *                         if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
 *                             treeifyBin(tab, hash);
 *                         break;
 *                     }
 *                     if (e.hash == hash &&
 *                         ((k = e.key) == key || (key != null && key.equals(k))))
 *                         break;
 *                     p = e;
 *                 }
 *             }
 *             if (e != null) { // existing mapping for key
 *                 V oldValue = e.value;
 *                 if (!onlyIfAbsent || oldValue == null)
 *                     e.value = value;
 *                 afterNodeAccess(e);
 *                 return oldValue;
 *             }
 *         }
 *         ++modCount;
 *         if (++size > threshold)
 *             resize();
 *         afterNodeInsertion(evict);
 *         return null;
 *     }
 *
 */



