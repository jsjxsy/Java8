package com;


/**
 * Created by admin on 2017/3/24.
 */
public class Student implements Name, Person {

    public Student(Name p) {

    }

    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return Person.super.getName();
    }


    public static void main(String[] args) {
        Name n = new Name() {
            @Override
            public String getName() {
                return "lisi";
            }
        };
        Student s = new Student(n);
        System.out.println(s.getName());
//        Optional<String> name = s::getName;
    }
}
