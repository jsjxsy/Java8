package com;

import java.lang.reflect.Field;

/**
 * Created by admin on 2017/4/7.
 */
public class Test {
    private  static  String classPath = "/Users/admin/IdeaProjects/out/production/ClassLoaderDemo/src/";
    public static void main(String[] args) {
        //inject(getClassLoader()); // error
        String classLoaderName = getClassLoader().getClass().getName();
        System.out.println("###onCreate in myApplication classLoaderName = " + classLoaderName);

//        inject(getClassLoader());
        String parentClassLoaderName = getClassLoader().getParent().getClass().getName();
        System.out.println("###onCreate in myApplication parentClassLoaderName = " + parentClassLoaderName);
//        String pParentClassLoaderName = getClassLoader().getParent().getParent().getClass().getName();
//        System.out.println("###onCreate in myApplication pParentClassLoaderName = " + pParentClassLoaderName);

    }

    public static ClassLoader getClassLoader() {
//        return Test.class.getClassLoader();
        return Thread.currentThread().getContextClassLoader();
    }

    private static void setParent(ClassLoader classLoader, ClassLoader newParent) {
        try {
            Field parent = ClassLoader.class.getDeclaredField("parent");
            parent.setAccessible(true);
            parent.set(classLoader, newParent);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }

    public static ClassLoader inject(ClassLoader classLoader) {
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(classLoader, classPath);
        setParent(classLoader, incrementalClassLoader);
        return incrementalClassLoader;
    }

}
