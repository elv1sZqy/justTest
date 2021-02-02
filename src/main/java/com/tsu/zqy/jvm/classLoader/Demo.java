package com.tsu.zqy.jvm.classLoader;

import sun.misc.Launcher;

import java.net.URL;
import java.net.URLClassLoader;

/**
 * @ClassName Demo
 * @Author Elv1s
 * @Date 2020/12/20 13:39
 * @Description:
 */
public class Demo {
    public static void main(String[] args) {
        int i = getInt();
        System.out.println(i);
        while (1==1) {
            if (1==2) {
                break;
            }

        }
        Demo demo = new Demo();
        ClassLoader applicationClassLoader = demo.getClass().getClassLoader();
        System.out.println(applicationClassLoader);
        System.out.println("=========================");

        ClassLoader extClassLoader = applicationClassLoader.getParent();
        System.out.println(extClassLoader);
        new Thread().start();

        System.out.println("========================");

        System.out.println("启动类加载器加载的路径：");
        URL[] urLs = Launcher.getBootstrapClassPath().getURLs();
        for (URL urL : urLs) {
            System.out.println(urL.toString());
        }

        System.out.println("========================");
        System.out.println("拓展类加载器加载的路径：");
        URL[] extUrls = ((URLClassLoader) extClassLoader).getURLs();
        for (URL extUrl : extUrls) {
            System.out.println(extUrl);
        }

        System.out.println("========================");
        System.out.println("应用类加载器加载的路径：");
        URL[] appUrls = ((URLClassLoader) applicationClassLoader).getURLs();
        for (URL appUrl : appUrls) {
            System.out.println(appUrl);
        }

        System.out.println("========================");

        ClassLoader applicationClassLoader2 = ClassLoader.getSystemClassLoader();
        System.out.println(applicationClassLoader2);
        System.out.println(applicationClassLoader == applicationClassLoader2);

        System.out.println("========================");

    }

    private static int getInt() {
        int i = 0;
        try {
            i = 1/0;
            return i=1;
        } catch (Exception e) {
            i++;
            return i;
        } finally {
            i++;
            return i;
        }
    }


    public String string(String s) {
        int i = 1 + 1;
        return "s";
    }
}
