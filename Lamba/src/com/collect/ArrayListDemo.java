package com.collect;

import java.util.Arrays;
import java.util.List;

/**
 * Created by admin on 2017/3/30.
 */
public class ArrayListDemo {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(1,2,3,4,5);
        list.stream().forEach(System.out::println);

        list.stream().forEach(e -> System.out.println(e));

        list.stream().forEach((Integer e) -> System.out.println(e));

        Arrays.asList( "a", "b", "d" ).sort( ( e1, e2 ) -> e1.compareTo( e2 ) );

    }
}
