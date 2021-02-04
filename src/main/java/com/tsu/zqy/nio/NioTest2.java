package com.tsu.zqy.nio;

import org.springframework.core.io.buffer.NettyDataBuffer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * @ClassName NioTest2
 * @Author Elv1s
 * @Date 2019/5/16 15:20
 * @Description:
 */
public class NioTest2 {
    private Selector selector;
    public static void main(String[] args) throws IOException {
        NioTest2 nioTest2 = new NioTest2();
        nioTest2.initServerNIO(9999);
        nioTest2.listenSelector();
    }

    private  void listenSelector() throws IOException {
        //一直监听
        while (true){
            selector.select();
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()){
                SelectionKey key = iterator.next();
                handler(key);
                iterator.remove();
            }
        }
    }

    /**
     * 处理方法
     * @param key
     */
    private void handler(SelectionKey key) throws IOException {

        //判断是什么类型的
        if (key.isAcceptable()){
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel socketChannel = serverSocketChannel.accept();
            socketChannel.configureBlocking(false);

            socketChannel.register(selector, SelectionKey.OP_READ);
        }

        else if (key.isReadable()){
            SocketChannel socketChannel = (SocketChannel) key.channel();

            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);

            if (read > 0){
                String str = new String(buffer.array() , "GBK");
                System.out.println(str);
            }
            else{
                System.out.println("客户端退出");
                key.cancel();
            }
        }
    }

    private  void initServerNIO(int port) throws IOException {
        this.selector = Selector.open();

        //服务器的管道注册到selector中
        ServerSocketChannel ssc = ServerSocketChannel.open();
        ssc.socket().bind(new InetSocketAddress(port));
        //非阻塞
        ssc.configureBlocking(false);

        //处于接受就绪状态
        ssc.register(selector, SelectionKey.OP_ACCEPT);
    }

}
