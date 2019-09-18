package com.example.dataStructure;

public class LinkedList<E> {
    //链表大小
   private int size;
    //指向第0个元素
   private Node<E> first;

   private static class Node<E>{
        //存储的元素
        E element;
        //指向下一个node
        Node<E> next;

       public Node(E element, Node<E> next) {
           this.element = element;
           this.next = next;
       }
   }

   public int size(){
       return  size;
   }

   public boolean isEmpty(){
       return size == 0;
   }

   public void clear(){
       size = 0;
       first = null;
   }
}

