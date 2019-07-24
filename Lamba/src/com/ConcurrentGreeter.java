package com;

/**
 * Created by admin on 2017/3/24.
 */
public class ConcurrentGreeter extends Greeter {
    @Override
    public void greet() {
        super.greet();
        Thread t = new Thread(super::greet);
        t.start();
    }

    public static void main(String[] args) {
        new ConcurrentGreeter().greet();
        System.out.println("========");
    }
}
