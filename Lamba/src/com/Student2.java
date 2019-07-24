package com;

import java.util.ArrayList;
import java.util.Objects;

/**
 * Created by admin on 2017/3/24.
 */
public class Student2 extends PersonClass implements Person {
    @Override
    public long getId() {
        return 0;
    }

    @Override
    public String getName() {
        return super.getName();
    }

    public static void main(String[] args) {
        ArrayList<Student> list = new ArrayList<>();
        list.stream().forEach(System.out::println);

        Student2 student2 = new Student2();
        Objects.isNull(student2);
        Objects.nonNull(student2);
    }
}
