package com.tsu.zqy.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

/**
 * @ClassName NIOTest
 * @Author Elv1s
 * @Date 2019/5/16 12:28
 * @Description:
 */
public class NIOTest {

    private  Selector selector;
    
   public static void main(String[] args) throws IOException {
       NIOTest nioTest = new NIOTest();
       nioTest.initNio(8888);
       nioTest.listenSelector();
   }

    /**
     * 监听selector
     * @throws IOException
     */
    private void listenSelector() throws IOException {
       //轮询监听selector
        while (true){
            this.selector.select();
            Set<SelectionKey> keys = this.selector.selectedKeys();
            keys.forEach(item->{
                try {
                    if (item.isAcceptable()){
                        System.out.println("进来一个人...");
                    }
                    else if (item.isReadable()){
                        System.out.println("是一个写的请求...");
                    }
                    handler(item);
                    keys.remove(item);
                } catch (IOException e) {
                    e.printStackTrace();
                }

            });
          /*  while (keys.hasNext()){
                SelectionKey key = keys.next();
                //处理请求
                handler(key);

                keys.remove();
            }*/
        }
    }

    /**
     * 处理客户端请求
     * @param key
     */
    private void handler(SelectionKey key) throws IOException {
       //处理连接事件
        if (key.isAcceptable()){
            //
            ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
            SocketChannel accept = serverSocketChannel.accept();
            //非阻塞
            accept.configureBlocking(false);

            //客户端的管道注册到select中
            accept.register(selector, SelectionKey.OP_READ);
        }
        //处理读事件
        else {
            SocketChannel socketChannel = (SocketChannel) key.channel();
            ByteBuffer buffer = ByteBuffer.allocate(1024);
            int read = socketChannel.read(buffer);

            if (read > 0){
                String str = new String(buffer.array(), "Gbk");
                System.out.println(str);


            }
            else {
                System.out.println("客户端关了....");
                key.cancel();
            }
        }

    }

    /**
     * 初始化服务
     * @param port
     * @throws IOException
     */
    private  void initNio(int port) throws IOException {
        ServerSocketChannel ssc = ServerSocketChannel.open();

        //把服务端管道绑定到端口
        ssc.socket().bind(new InetSocketAddress(port));
        //设置为非阻塞
        ssc.configureBlocking(false);

        //选择器
        this.selector = Selector.open();

        //注册监听级别的
        ssc.register(selector, SelectionKey.OP_ACCEPT);

        System.out.println("服务器已经启动....");

    }




}
