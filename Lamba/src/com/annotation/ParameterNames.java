package com.annotation;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Scanner;

/**
 * Created by admin on 2017/4/6.
 */
public class ParameterNames {
    public static void main(String[] args) {
        Method method = null;
        try {
            method = ParameterNames.class.getMethod("main", String[].class);
            for (final Parameter parameter : method.getParameters()) {
                System.out.println("Parameter: " + parameter.getName());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        try(Scanner in = new Scanner("/usr/share/dict/wordss")) {
            while(in.hasNext())
                System.out.println(in.next().toLowerCase());
        }
    }

}
