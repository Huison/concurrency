package com.example.Clone;

import lombok.*;
import lombok.extern.slf4j.Slf4j;

/**
 *
 *
 */
@Slf4j
public class CloneExample1 {
    public static void main(String[] args) throws CloneNotSupportedException {
        FatherClass fatherA = new FatherClass();
        fatherA.name = "张三";
        fatherA.age = 18;
        FatherClass fatherB = (FatherClass)fatherA.clone();
        log.info("fatherA: {}", fatherA);
        log.info("fatherB: {}", fatherB);
        log.info("fatherA=fatherB: {}", fatherA==fatherB);
        log.info("fatherA.hashcode: {}", fatherA.hashCode());
        log.info("fatherB.hashcode: {}", fatherB.hashCode());
        log.info("fatherA equal fatherB {}", fatherA.equals(fatherB));

    }
}

@Getter
@Setter
class FatherClass implements Cloneable{
    public String name;
    public int age;
    public ChildClass childClass;


    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}


@Data
class ChildClass{

}
