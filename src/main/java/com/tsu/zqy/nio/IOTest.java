package com.tsu.zqy.nio;

import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @ClassName IOTest
 * @Author Elv1s
 * @Date 2019/5/16 8:15
 * @Description:
 */
public class IOTest {

    @Test
    public void test1() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        ExecutorService pool = Executors.newCachedThreadPool();
        //开始接待客人
        System.out.println("开始接客");

        while (true){
            pool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        //获取客户端套接字.
                        Socket socket = serverSocket.accept();
                        System.out.println("来了一个新客人");

                        InputStream inputStream = socket.getInputStream();

                        byte[] bytes = new byte[1024];
                        while (true) {
                            int read = inputStream.read(bytes);
                            if (read != -1) {
                                String str = new String(bytes, 0, read, "GBK");
                                System.out.println(str);
                            } else {
                                System.out.println("客人走了");
                                break;
                            }
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            });

        }

    }
}
