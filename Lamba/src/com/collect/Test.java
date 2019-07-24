package com.collect;

import java.util.*;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/25.
 */
public class Test {
    public static void main(String[] args) {

//        int one_million = 1_000_000;
//        int binary = 0b1001_1001;
//
//        List<Integer> nums = new ArrayList<>();
//        nums.add(1);
//        nums.add(null);
//        nums.add(2);
//        nums.add(null);
//        nums.add(3);
//        long count = nums.stream().filter(num -> num != null).count();
//        System.out.println(count);
//        nums.stream().distinct().forEach(System.out::println);
//
//        nums.stream().mapToInt(a -> a + 2).forEach(System.out::println);
//        nums.stream().peek(System.out::println).limit(4).skip(1);
//
//
//        Stream<Integer> integerStream = Stream.of(1, 2, 3, 4, null);
//        Stream.generate(new Supplier<Integer>() {
//            @Override
//            public Integer get() {
//                return 12;
//            }
//        }).limit(3);
//        Stream.generate(() -> 12);
//        Stream.generate(Math::random).limit(1);
//
//
//        Stream.iterate(1, item -> item + 1).limit(10).forEach(System.out::println);


        List<String> list = Arrays.asList("one","two","three","one");
        list.stream().forEach(System.out::println);
        System.out.println("===========");
        Set<String> set = new LinkedHashSet<>(list);
        set.stream().forEach(System.out::println);


    }
}
