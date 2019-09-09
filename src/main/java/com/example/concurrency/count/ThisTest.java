package com.example.concurrency.count;

public class ThisTest {
   private int a;
   private String string;
   Wdnm wdnm = new Wdnm();

   public void deletebaba(){
       wdnm.woshinibaba(this);
       System.out.println("deletebaba" + this);
   }

    public static void main(String[] args) {
        ThisTest thisTest = new ThisTest();
        System.out.println("Thistest" + thisTest);
        thisTest.deletebaba();
    }

}

class Wdnm{
    int c;
    public void woshinibaba(Object o){
        System.out.println("ooo" + o);
            this.eh();
        System.out.println("wdnm" + this);
    }

    public void  eh(){
        System.out.println(2);
    }

}
