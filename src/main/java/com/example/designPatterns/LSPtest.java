package com.example.designPatterns;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 *
 *  里氏替换原则
 *
 *  反射在子类方面还有些问题
 *
 */
public class LSPtest {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Bird bird1 = new Swallow();
        Animal bird2 = new BrownKiwi();


        /**
         * 反射访问私有方法
         */
        Class classBird1 = bird1.getClass();
        Method setSpeed = classBird1.getDeclaredMethod("setSpeed");
        setSpeed.setAccessible(true);
        setSpeed.invoke(bird1,120);

        Method getFlyTime = classBird1.getDeclaredMethod("getFlyTime");
        getFlyTime.setAccessible(true);
        System.out.println(getFlyTime.invoke(bird1, 300));


        Class classBird2 = bird2.getClass();
        Method setRunSpeed = classBird2.getDeclaredMethod("setRunSpeed");
        setRunSpeed.setAccessible(true);
        setRunSpeed.invoke(bird2,120);

        Method getRunTime = classBird2.getDeclaredMethod("getRunTime");
        getRunTime.setAccessible(true);
        System.out.println(getFlyTime.invoke(getRunTime, 300));


    }
}

class Animal{
    private double runspeed;

    private void setRunSpeed(double speed){
        runspeed = speed;
    }

    private double getRunTime(double distance){
        return distance/runspeed;
    }
}

class Bird extends Animal{
    private double flySpeed;

    private void setSpeed(double speed){
       this.flySpeed = speed;
    }

    private double getFlyTime(double distance){
        return distance/flySpeed;
    }

}


/**
 * 燕子类
 */
class Swallow extends Bird{

}


/**
 * 几维鸟类 这种鸟没有飞行能力 如果继承鸟类,要重写父类方法.
 */
class BrownKiwi extends Animal{

}