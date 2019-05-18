package com.tsu.zqy.File;

import java.io.File;

/**
 * @ClassName FileTest
 * @Author Elv1s
 * @Date 2019/4/18 7:43
 * @Description:
 */
public class FileTest {
    
    public static void main(String[] args){
        File file = new File("D:\\图片");
        System.out.println(file);   

       /* String[] list = file.list();
        for (String f  :list ) {
            System.out.println(f);
        }*/

        File[] listFiles = file.listFiles();
        for (File f  :listFiles ) {
           show(f);
        }
    }

    public static void show(File file) {
        //是文件夹
        if (file.isDirectory()){
            System.out.println(file.getAbsolutePath());
            for (File f  :file.listFiles() ) {
                show(f);
            }
        }
        //是文件的情况
        else{
            //System.out.println(file.getAbsolutePath());
            if (file.getName().endsWith(".png")){
                System.out.println(file.getAbsolutePath());
            }
        }
    }

}
