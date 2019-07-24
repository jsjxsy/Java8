package com.annotation;

/**
 * Created by admin on 2017/3/30.
 */
@FunctionalInterface
public interface Functional {
    void test();
    default void defaultMethod() {
    }
}
