package com.tsu.zqy.util;


import com.github.jarlakxen.embedphantomjs.ExecutionTimeout;
import com.github.jarlakxen.embedphantomjs.PhantomJSReference;
import com.github.jarlakxen.embedphantomjs.executor.PhantomJSConsoleExecutor;
import com.github.jarlakxen.embedphantomjs.executor.PhantomJSFileExecutor;

import java.io.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuQiYun
 * @create 2020/3/26
 * @description :
 */
public class PPP {
    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {
        String BLANK = " ";
        String command = "D:\\Program Files\\phantomjs-2.5.0-beta2-windows\\bin\\phantomjs.exe  D:\\Program Files\\phantomjs-2.5.0-beta2-windows\\bin\\test.js";
        System.out.println(command);
        Process process = Runtime.getRuntime().exec(command);
        InputStream inputStream = process.getInputStream();

        InputStreamReader isr = new InputStreamReader(inputStream,"GBK");
        BufferedReader br = new BufferedReader(isr);
        String line = null;
        while ((line = br.readLine()) != null){
            System.out.println(line);
        }
        System.out.println("");
        int exitVal = process.waitFor();
        System.out.println("Process exitValue: " + exitVal);

       PhantomJSConsoleExecutor ex = new PhantomJSConsoleExecutor(PhantomJSReference.create().build());
         /*ex.start();
        ex.execute("var system = require('system');");
        System.out.println(ex.execute("system.stdout.writeLine('TEST1');", "true")); // This prints "TEST1"
        System.out.println( ex.execute("system.stdout.writeLine('TEST2');", "true")); // This prints "TEST2"
        ex.destroy();*/
    }
}
