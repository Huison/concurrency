package com.example.designPatterns;

import com.example.concurrency.reflect.Book;

/**
 *  依赖倒置原则:面向接口编程
 *
 *  我们在实际编程中只要遵循以下4点，就能在项目中满足这个规则:
 *      ①每个类尽量提供接口或抽象类，或者两者都具备。
 *      ②变量的声明类型尽量是接口或者是抽象类。
 *      ③任何类都不应该从具体类派生。
 *      ④使用继承时尽量遵循里氏替换原则。
 *
 *
 */
public class DIPtest {
    public static void main(String[] args) {
        Customer customer = new Customer();
        Shop ballShop = new BallShop();
        Shop bookshop = new Bookshop();
        customer.shopping(ballShop);
        customer.shopping(bookshop);
    }
}

class BallShop implements Shop{
    @Override
    public void sell(){
        System.out.println("卖球的");
    }
}

class Bookshop implements Shop{
    @Override
    public void sell(){
        System.out.println("卖书的");
    }

}

interface Shop{
    public void sell();
}

class Customer{
    public void shopping(Shop shop){
        shop.sell();
    }
}