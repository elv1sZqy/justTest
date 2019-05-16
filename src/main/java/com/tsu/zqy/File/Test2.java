package com.tsu.zqy.File;

import java.io.File;

/**
 * @ClassName Test2
 * @Author Elv1s
 * @Date 2019/4/18 8:15
 * @Description:
 */
public class Test2 {

    public static void main(String[] args){
        File file = new File("D:\\图片");
        //匿名内部类方式

        /*File[] listFiles = file.listFiles(new FileFilter() {
            public boolean accept(File pathname) {
                //if (pathname.getName().endsWith(".jpg")){
                //    return true;
                //}
                //return false;
                return pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".png");
            }
        });*/
        //lambda表达式
        File[] listFiles = file.listFiles((pathName) ->
                pathName.isDirectory() || pathName.getName().toLowerCase().endsWith(".png")
        );
       /* File[] listFiles = file.listFiles(pathname -> {
            if (pathname.isDirectory() || pathname.getName().toLowerCase().endsWith(".png")) {
                return true;
            } else {
                return false;
            }
        });*/

        for (File f  :listFiles ) {
        FileTest.show(f);
    }
}



}
