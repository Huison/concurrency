package com.example.Clone;

import lombok.Data;
import org.junit.jupiter.api.Test;

@Data
class Person implements Cloneable{
    public int age = 2;
    public String name = "diao";

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }


@Test
public void  test() throws CloneNotSupportedException {
    Person person = new Person();
    Person person1 = (Person) person.clone();
    person.setName("qqq");
    person.setAge(3);
    System.out.println(person.getName());
    System.out.println(person1.getName());
    System.out.println(person1.getAge());
}

}
