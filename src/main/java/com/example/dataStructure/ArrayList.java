package com.example.dataStructure;


import lombok.extern.slf4j.Slf4j;

/**
 *
 *  动态数组的实现
 *
 */
@Slf4j
public class ArrayList {
    //数组中元素的数量
    private int size;

    //所有的元素
    private int[] elements;

    //默认数组的容量
    private static final int DEFAULT_CAPACITY = 16;
    //标示元素没找到
    private static final int ELEMENT_NOT_FOUND = -1;



    public ArrayList(int capacity){
        capacity = capacity > DEFAULT_CAPACITY ? capacity : DEFAULT_CAPACITY;
        elements = new int[capacity];
    }

    public ArrayList(){
        this(DEFAULT_CAPACITY);
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    //是否包含这个元素
    public boolean contains(int element){
        return indexOf(element) != ELEMENT_NOT_FOUND;
    }

    //添加元素到最后面 0 1 2
    public void add(int element){
       add(size, element);
    }

    //返回index位置对应的元素
    public int get(int index){
        checkIndex(index);
        return elements[index];
    }

    //设置index位置的元素
    //返回原来的元素
    public int set(int index, int element){
        checkIndex(index);
        //获取原来的元素
        int old = elements[index];
        elements[index] = element;
        return old;
        }


    //查看元素的位置
    public int indexOf(int element){

        for (int i = 0; i <size ; i++) {
            if(elements[i] == element){
                return i;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public void clear(){
        size = 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int i = 0; i < size; i++) {
            if(i != 0){
                stringBuilder.append(", ");
            }
            stringBuilder.append(elements[i]);
        }
        stringBuilder.append("]");
        return stringBuilder.toString();
    }


    //删除index位置对应的元素
    public void remove(int index){
        checkIndex(index);

        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        size--;
    }

    public void outOfBoundes(int index){
        throw new IndexOutOfBoundsException("index=" + index + ",but size=" + size);
    }

    public void checkIndex(int index){
        if(index < 0 || index >= size) {
            outOfBoundes(index);
        }
    }

    public void checkIndexForAdd(int index){
        if(index < 0 || index > size) {
            outOfBoundes(index);
        }
    }

    //往index位置添加元素
    public void add(int index, int element){
        checkIndexForAdd(index);

        /**
         * 默认数组容量为16,当要插入第17个元素的时候就要对其进行扩容
         */
        ensuerCapacity(size);

        for (int i = size; i > index; i--) {
            elements[i] = elements[i - 1];
        }
        elements[index] = element;
        size++;
    }

    /**
     *
     *
     */
    private void ensuerCapacity(int size) {
        //原始数组的容量16
        int oldCapacity = elements.length;
        //如果当前数组元素个数小于数组容量,就不扩容
        if(size < oldCapacity) {
            return;
        }else {
            //扩容1.5倍 24
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            int[] newElements = new int[newCapacity];
            log.info("原来容量{}扩容后为{}", oldCapacity, newCapacity);
            for (int i = 0; i < size; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }

    }

    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        log.info("list={}", list);
    }
}
