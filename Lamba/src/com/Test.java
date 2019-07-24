package com;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/24.
 */
public class Test {
    private String name;

    public static void main(String[] args) {
//        repeatMessage("this is test", 10);
//        new Test().repeatMessage2("this is test 2", 5);
//        new Test().test();
        new Test().test3();
    }

    public static void repeatMessage(String text, int count) {
        Runnable r = () -> {
            for (int i=0;i<count;i++) {
                System.out.println("test-->"+text);
                Thread.yield();
            }
        };

        new Thread(r).start();

//        Runnable r = () -> {
//            while (count>0) {
//                count--;
//                System.out.println("test-->"+text);
//                Thread.yield();
//            }
//        };
//        new Thread(r).start();


    }


    public void repeatMessage2(String text, int count) {
        Runnable r = () -> {
            for (int i=0;i<count;i++) {
                System.out.println("test-->"+text);
                System.out.println(this.toString());
                Thread.yield();
            }
        };

        new Thread(r).start();
    }

    public void test() {
        String[] list = new String[]{"one","two","three"};
        for (String str : list) {
            System.out.println(str);
        }
        for (int i = 0; i < list.length; i++) {
            System.out.println(list[i]);
        }
        ArrayList<String> list1 = new ArrayList();
        list1.add("one");
        list1.add("two");
        list1.add("three");
        list1.forEach(System.out::println);

    }


    public static void test2() {
        ArrayList<Name> list1 = new ArrayList();
        Stream<NameD> stream = list1.stream().map(NameD::new);
        List<NameD> list = stream.collect(Collectors.toList());

    }

    public static void test3() {
        for(int i =0; i> 0 ; i--) {
            System.out.println("======");
        }
    }

}
