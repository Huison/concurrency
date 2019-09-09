package com.example.concurrency.count;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class ReflectTest {
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int age;

}

class Gxe{
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException, InstantiationException {
        ReflectTest reflectTest = new ReflectTest();
        Class cl = reflectTest.getClass();
        Object sd = cl.newInstance();








//        try {
//            Object sd = cl.newInstance();
//            System.out.println("rrrrr" + sd);
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
//
//        try {
//            Constructor c = cl.getConstructor();
//            try {
//                Object o = c.newInstance();
//                System.out.println(o);
//            } catch (InstantiationException e) {
//                e.printStackTrace();
//            } catch (IllegalAccessException e) {
//                e.printStackTrace();
//            } catch (InvocationTargetException e) {
//                e.printStackTrace();
//            }
//        } catch (NoSuchMethodException e) {
//            e.printStackTrace();
//        }


//        try {
//            System.out.println(Class.forName("com.example.concurrency.count.ReflectTest"));
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Field[] fields1 = reflectTest.getClass().getFields();
//        for (Field field:fields1){
//            System.out.println(field.getName());
//        }
//        for (Field field:fields){
//            String name = field.getName();
//            System.out.println(name);
//        }

    }
}