package com;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by admin on 2017/4/7.
 */
public class TestClassLoader {
    private static String classPath = "/Users/admin/IdeaProjects/out/production/ClassLoaderDemo/src/";
    public static void main(String[] args) {
//       test();
//        test2();
//        test3();
//        test4();
//        test5();
//        test6();
        test7();
    }


    public static void test() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(classLoader, classPath);
        Thread.currentThread().setContextClassLoader(incrementalClassLoader);
        try {
            Class<?> clazz = incrementalClassLoader.loadClass("com.HelloWorld");
            HelloWorld helloWorld = (HelloWorld) clazz.newInstance();
            helloWorld.sayHello();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public static void test2() {
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(null,classPath);
        try {
            Class<?> clazz = incrementalClassLoader.loadClass("com.HelloWorld");
            HelloWorld helloWorld = (HelloWorld) clazz.newInstance();
            helloWorld.sayHello();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();

        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }


    public static void test3() {
        new Thread(new Runnable() {

            @Override
            public void run() {
                System.out.println("Thread "+Thread.currentThread().getName()+" classloader: "+Thread.currentThread().getContextClassLoader().toString());

                // TODO Auto-generated method stub
                try {
                    //加载class文件
                    //  Thread.currentThread().setContextClassLoader(diskLoader);
                    //Class c = diskLoader.loadClass("com.frank.test.SpeakTest");
                    ClassLoader cl = Thread.currentThread().getContextClassLoader();
                    IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(cl, classPath);
//                    Class c = cl.loadClass("com.HelloWorld");
                    Class c =  incrementalClassLoader.loadClass("com.HelloWorld");

                    // Class c = Class.forName("com.frank.test.SpeakTest");
                    System.out.println(c.getClassLoader().toString());
                    if(c != null){
                        try {
                            Object obj = c.newInstance();
                            //SpeakTest1 speak = (SpeakTest1) obj;
                            //speak.speak();
                            Method method = c.getDeclaredMethod("sayHello",null);
                            //通过反射调用Test类的say方法
                            method.invoke(obj, null);
                        } catch (InstantiationException | IllegalAccessException
                                | NoSuchMethodException
                                | SecurityException |
                                IllegalArgumentException |
                                InvocationTargetException e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }
                } catch (ClassNotFoundException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static void test4() {
        System.out.println(System.getProperty("sun.boot.class.path"));
        System.out.println(System.getProperty("java.ext.dirs"));
        System.out.println(System.getProperty("java.class.path"));

    }


    public static void test5() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(classLoader, classPath);
        String classLoaderName = incrementalClassLoader.getClass().getName();
        System.out.println("###onCreate in myApplication classLoaderName = " + classLoaderName);

        String parentClassLoaderName = incrementalClassLoader.getParent().getClass().getName();
        System.out.println("###onCreate in myApplication parentClassLoaderName = " + parentClassLoaderName);
        String pParentClassLoaderName = incrementalClassLoader.getParent().getParent().getClass().getName();
        System.out.println("###onCreate in myApplication pParentClassLoaderName = " + pParentClassLoaderName);
    }

    public static void test6() {
        NetworkClassLoader networkClassLoader = new NetworkClassLoader(classPath);
        IncrementalClassLoader incrementalClassLoader = new IncrementalClassLoader(classPath);
        setParent(networkClassLoader,incrementalClassLoader);
        String classLoaderName = networkClassLoader.getClass().getName();
        System.out.println("###onCreate in myApplication classLoaderName = " + classLoaderName);

        String parentClassLoaderName = networkClassLoader.getParent().getClass().getName();
        System.out.println("###onCreate in myApplication parentClassLoaderName = " + parentClassLoaderName);
        String pParentClassLoaderName = networkClassLoader.getParent().getParent().getClass().getName();
        System.out.println("###onCreate in myApplication pParentClassLoaderName = " + pParentClassLoaderName);
    }


    public static void test7() {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        String classLoaderName = classLoader.getClass().getName();
        System.out.println("###onCreate in myApplication classLoaderName = " + classLoaderName);

        String parentClassLoaderName = classLoader.getParent().getClass().getName();
        System.out.println("###onCreate in myApplication parentClassLoaderName = " + parentClassLoaderName);
        String pParentClassLoaderName = classLoader.getParent().getParent().getClass().getName();
        System.out.println("###onCreate in myApplication pParentClassLoaderName = " + pParentClassLoaderName);
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
