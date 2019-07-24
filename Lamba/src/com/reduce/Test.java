package com.reduce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/30.
 */
public class Test {
    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 1, null, 2, 3, 4, null, 5, 6, 7, 8, 9, 10);
        List<Integer> numsWithoutNull = nums.stream().
                filter(num -> num != null).
                collect(() -> new ArrayList<Integer>(),
                        (list, item) -> list.add(item),
                        (list1, list2) -> list1.addAll(list2));
        numsWithoutNull.forEach(System.out::println);


        List<Integer> numsWithoutNull2 = nums.stream().filter(num -> num != null).
                collect(Collectors.toList());

        numsWithoutNull2.forEach(System.out::println);


        List<Integer> ints = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints.stream().reduce((sum, item) -> sum + item).get());

        List<Integer> ints2 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints2.stream().reduce(9, (sum, item) -> sum + item));

        List<Integer> ints3 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println("ints sum is:" + ints3.stream().count());

        List<Integer> ints4 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        System.out.println(ints4.stream().allMatch(item -> item < 100));
        ints.stream().max((o1, o2) -> o1.compareTo(o2)).ifPresent(System.out::println);

        Stream<String> unique = Stream.of("one","one","one","two").distinct();
        unique.forEach(System.out::println);

        List<String> words = Arrays.asList("one","two","three","four","five");
        words.sort(Comparator.comparing(String::length));

        words.stream().forEach(System.out::println);
    }
}
