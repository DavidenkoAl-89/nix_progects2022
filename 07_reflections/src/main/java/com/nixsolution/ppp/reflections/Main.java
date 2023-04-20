package com.nixsolution.ppp.reflections;

import com.nixsolution.ppp.reflections.test.ObjectTest1;
import com.nixsolution.ppp.reflections.test.ObjectTest2;
import com.nixsolution.ppp.reflections.test.Test;
import com.nixsolutions.ppp.reflection.PathClassLoader;
import com.nixsolutions.ppp.reflection.ReflectionUtil;


import java.nio.file.Path;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Test test = new Test();
        ObjectTest1 objectTest1 = new ObjectTest1();
        ObjectTest2 objectTest2 = new ObjectTest2();
        PathClassLoader classLoader = new PathClassLoaderImpl();
        Path path = Path.of("src/main/java/com/nixsoltion/ppp/reflections/test");
        PathClassLoader pathClassLoader = new PathClassLoaderImpl();
        pathClassLoader.setPath(path);
        Class<?> clazz = pathClassLoader.findClass("Test");
        System.out.println(clazz);

        ReflectionUtil reflectionUtil = new ReflectionUtilImpl();
        System.out.println(reflectionUtil.isTheSame(objectTest1, objectTest2));
        System.out.println(reflectionUtil.toString(objectTest2));
        System.out.println(reflectionUtil.isTheSame(objectTest1, objectTest2));


    }
}

