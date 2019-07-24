package com.reduce;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by admin on 2017/3/31.
 */
public class ReduceDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6);
        Stream<Integer> integerStream = list.stream();
        Optional<Integer> integerOptional = integerStream.reduce((x, y) -> x + y);
        System.out.println("sum:" + integerOptional.get());
        Optional<Integer> values = list.stream().reduce(Integer::sum);
        System.out.println("values:" + values.get());
        List<String> array = Arrays.asList("one", "two", "three", "four", "five");
        int sum = array.stream().mapToInt(String::length).sum();
        System.out.println("sum: " + sum);

        String[] result = array.stream().toArray(String[]::new);
        System.out.println("result: "+result);
        Arrays.asList(result).stream().forEach(System.out::println);

        List<String> words = Arrays.asList("one","two","three");
        HashSet<String> result2 = words.stream().collect(HashSet::new, HashSet::add, HashSet::addAll);
        result2.stream().forEach(System.out::println);


        List<String> words2 = words.stream().collect(Collectors.toList());
        Set<String> words3 = words.stream().collect(Collectors.toSet());
        String result3 = words.stream().collect(Collectors.joining());
        System.out.println(result3);
        String result4 = words.stream().map(Object::toString).collect(Collectors.joining(", "));
        System.out.println(result4);

    }
}
