package com.annotation.annotationprocessor;

/**
 * Created by admin on 2017/4/1.
 */
@HelloWorld
public class HelloWorldDemo {
    private int id;
    private String name;

    public HelloWorldDemo(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
