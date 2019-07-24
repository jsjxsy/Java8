package com.optional;

import java.util.*;

/**
 * Created by admin on 2017/3/30.
 */
public class OptionalDemo {
    public static void main(String[] args) {
        List<String> words = Arrays.asList("one", "two", "three", "four", "five");
        Optional<String> optionalValue = words.stream().max(String::compareToIgnoreCase);
        if (optionalValue.isPresent()) {
            System.out.println("words:" + optionalValue.get());
        }

        ArrayList<String> results = new ArrayList<>();
        optionalValue.ifPresent(results::add);
        System.out.println("results:" + results);

        Optional<Boolean> result = optionalValue.map(results::add);
        System.out.println("result:" + result.get());

        Optional<String> optionalString = words.stream().filter(s -> s.startsWith("f")).findFirst();
        if (optionalString.isPresent()) {
            System.out.println("words:" + optionalString.get());
            System.out.println("word:" +Optional.empty().orElse("this is else word"));
            System.out.println("word:" +Optional.empty().orElseGet(() -> System.getProperty("usr.dir")));
            System.out.println("word:" +optionalString.orElseThrow(NoSuchElementException::new));
            System.out.println("word String : "+ Optional.of("String").get());
            System.out.println("Optional : "+ Optional.empty());

        }

    }
}
