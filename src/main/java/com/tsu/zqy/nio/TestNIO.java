package com.tsu.zqy.nio;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * @author zhuQiYun
 * @create 2021/1/29
 * @description :
 */
public class TestNIO {
    public static void main(String[] args) throws IOException, InterruptedException {
        Selector selector = Selector.open();
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.bind(new InetSocketAddress(8080));
        ssc.register(selector, SelectionKey.OP_ACCEPT);
        ssc.configureBlocking(false);

        while (true) {
            int select = selector.select();
            if (select > 0) {
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                for (SelectionKey selectionKey : selectionKeys) {
                    handler(selectionKey);
                }
            } else {
                TimeUnit.SECONDS.sleep(1);
            }
        }
    }

    private static void handler(SelectionKey selectionKey) {
        if (selectionKey.isReadable()) {
            System.out.println("读数据");
        } else if (selectionKey.isWritable()) {
            System.out.println("写数据");
        }
    }
}
