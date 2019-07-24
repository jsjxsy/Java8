package com;

/**
 * Created by admin on 2017/3/24.
 */
public interface Person {
     String Sex = "female";

    long getId();

    default String getName() {
        return "zhangsan";
    }

    static String getSex() {
        return Sex;
    }

//    static void setSex(String sex) {
//        Sex = sex;
//    }

}
