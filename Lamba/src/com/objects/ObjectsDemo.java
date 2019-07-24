package com.objects;

import com.reduce.Student;

import java.util.Objects;

/**
 * Created by admin on 2017/4/6.
 */
public class ObjectsDemo {
    public static void main(String[] args) {
        System.out.println("student object is null ? " + Objects.isNull(new Student(1, "zhnangsan")));
        System.out.println("student object is not null ? "+Objects.nonNull(new Student(1, "zhnangsan")));

    }
}
