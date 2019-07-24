package com;

import java.io.*;

/**
 * Created by admin on 2017/4/7.
 */
public class IncrementalClassLoader extends ClassLoader {
    public static final boolean DEBUG_CLASS_LOADING = false;
    private String classPath = "/Users/admin/IdeaProjects/out/production/ClassLoaderDemo/src/";

    public IncrementalClassLoader(String classPath) {
        this.classPath = classPath;
    }

    public IncrementalClassLoader(ClassLoader parent, String classPath) {
        super(parent.getParent());
        this.classPath = classPath;
    }

    public Class<?> findClass(String className) throws ClassNotFoundException {
        System.out.println("IncrementalClassLoader find class");
        byte[] data = loadClassData(className);
        return defineClass(className, data, 0, data.length);
    }


    private byte[] loadClassData(String name) {
        name = name.replace(".", "//");
        try {
            FileInputStream is = new FileInputStream(new File(classPath + name + ".class"));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            int b;
            while ((b = is.read()) != -1) {
                byteArrayOutputStream.write(b);
            }
            return byteArrayOutputStream.toByteArray();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
