//package com.example.concurrency.HashMapEEEE;
//
//public class HashMap1 {
//    final V putVal(int hash, K key, V value, boolean onlyIfAbsent,
//                     boolean evict) {
//          Node<K,V>[] tab;
//          Node<K,V> p;
//          int n, i;
//          //初始化
//          if ((tab = table) == null || (n = tab.length) == 0)
//              //数组的长度 默认为16
//              n = (tab = resize()).length;
//          //如果算出来的这个元素的位置是空的,就把这个键值对放在这个位置
//          if ((p = tab[i = (n - 1) & hash]) == null)
//              tab[i] = newNode(hash, key, value, null);
//          //如果这个位置有元素
//          else {
//              Node<K,V> e; K k;
//              //节点的key相同,直接覆盖节点
//              if (p.hash == hash &&
//                  ((k = p.key) == key || (key != null && key.equals(k))))
//                  e = p;
//              //判断该链为红黑树
//              else if (p instanceof TreeNode)
//                  //如果是红黑树,那么往树里面插入元素
//                  e = ((TreeNode<K,V>)p).putTreeVal(this, tab, hash, key, value);
//              else {
//                  //不是红黑树,那么就遍历当前链表
//                  for (int binCount = 0; ; ++binCount) {
//                      if ((e = p.next) == null) {
//                          //创建节点加到链表尾部
//                          p.next = newNode(hash, key, value, null);
//                          //链表长度大于等于8,将链表转成红黑树
//                          if (binCount >= TREEIFY_THRESHOLD - 1) // -1 for 1st
//                              treeifyBin(tab, hash);
//                          break;
//                      }
//                      //判断是否有重复元素
//                      if (e.hash == hash &&
//                          ((k = e.key) == key || (key != null && key.equals(k))))
//                          break;
//                      p = e;
//                  }
//              }
//              //替换旧值
//              if (e != null) { // existing mapping for key
//                  V oldValue = e.value;
//                  if (!onlyIfAbsent || oldValue == null)
//                      e.value = value;
//                  afterNodeAccess(e);
//                  return oldValue;
//              }
//          }
//          //迭代器,failfast
//          ++modCount;
//          //判断我当前的hashmap容量是否已经达到扩容阀值
//          if (++size > threshold)
//              resize();//扩容
//          afterNodeInsertion(evict);
//          return null;
//      }
//}
