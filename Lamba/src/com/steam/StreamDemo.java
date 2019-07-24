package com.steam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/31.
 */
public class StreamDemo {
    public static void main(String[] args) {
//        IntStream stream = IntStream.of(1,1,2,3,4);
//        stream.forEach(System.out::println);
//        int[] nums = new int[]{1,2,3,4,5};
//        IntStream stream = Arrays.stream(nums,0,4);
//        stream.forEach(System.out::println);
//        IntStream stream1 = IntStream.range(0,100);
//        stream1.forEach(System.out::println);

//        IntStream stream2 = IntStream.rangeClosed(0,100);
//        stream2.forEach(System.out::println);

//        List<String> words = Arrays.asList("one", "two", "three");
//        Stream<String> w = words.parallelStream();
//        w.forEach(System.out::println);

//        int[] shortWords = new int[12];
//        words.stream().parallel().forEach(
//                s -> {
//                    if (s.length() < 12)
//                        shortWords[s.length()]++;
//                }
//        );
//        System.out.println(Arrays.toString(shortWords));

        IntStream.iterate(0,i ->(i +1)%2).parallel().distinct().limit(10).forEach(System.out::println);

    }



}
