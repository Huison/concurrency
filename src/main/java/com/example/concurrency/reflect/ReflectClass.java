package com.example.concurrency.reflect;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectClass {
    private final static String TAG = "peter.log.ReflectClass";

    //创建对象
    public static void reflectNewInstance() {
        try {
            Class<?> classBook = Class.forName("com.example.concurrency.reflect.Book");
            Object objectBook = classBook.newInstance();
            Book book = (Book) objectBook;
            book.setName("狂人日记");
            book.setAuthor("鲁迅");
            System.out.println("reflectNewInstance = " + book.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //反射私有属性
    public static void reflectPrivateField() {
        try {
            //这个类的字节码文件对象
            Class<?> classBook = Class.forName("com.example.concurrency.reflect.Book");
            //根据变量名获得字段
            Field fieldTag = classBook.getDeclaredField("TAG");
            //设置方法允许操作私有属性
            fieldTag.setAccessible(true);
            Object objectBook = classBook.newInstance();
            String tag = (String) fieldTag.get(objectBook);
            System.out.println("reflectPrivateField = " + tag);

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    //反射私有方法
    public static void reflectPrivateMethod(){
        try {
            Class<?> classBook = Class.forName("com.example.concurrency.reflect.Book");
            Method declaredMethod = classBook.getDeclaredMethod("declaredMethod", int.class);
            declaredMethod.setAccessible(true);
            Object objectBook = classBook.newInstance();
            Book book = (Book)objectBook;
            String string = (String)declaredMethod.invoke(book,0);
            System.out.println(string);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        reflectNewInstance();
        reflectPrivateField();
        reflectPrivateMethod();
    }
}
