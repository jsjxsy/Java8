package com.reduce;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/31.
 */
public class Student {
    private String name;
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Student(int id, String name) {
        this.name = name;
        this.id = id;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(new Student(1, "zhangsan"), new Student(2, "lisi"));
        Map<Integer, String> studentMap = students.stream().collect(Collectors.toMap(Student::getId, Student::getName));
        System.out.println("student map : " + studentMap);

        Stream<Student> student = Stream.of(new Student(3,"wangwu"));
        System.out.println("student " + student);
        student.forEach(System.out::println);
    }
}
