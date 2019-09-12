package com.example.Clone;


import lombok.Data;


@Data
public class ShallowCopyExample1 {
    private Age age;
    private String name;

    public ShallowCopyExample1(Age age, String name) {
        this.age = age;
        this.name = name;
    }

    public ShallowCopyExample1(ShallowCopyExample1 shallowCopyExample1){
        this.age = shallowCopyExample1.age;
        this.name = shallowCopyExample1.name;
    }



    public static void test(){
        Age age =  new Age(18);
        ShallowCopyExample1 shallowCopyExample1 = new ShallowCopyExample1(age, "libai");
        ShallowCopyExample1 shallowCopyExample2 = new ShallowCopyExample1(shallowCopyExample1);
        shallowCopyExample1.setAge(new Age(20));
        shallowCopyExample1.setName("dufu");
        System.out.println(shallowCopyExample1.getName() + ";" + shallowCopyExample1.getAge());
        System.out.println(shallowCopyExample2.getName() + ";" + shallowCopyExample2.getAge());
    }


    public static void main(String[] args) {
        test();
    }
}

@Data
class Age{
    private int age;

    public Age(int age){
        this.age = age;
    }
}
