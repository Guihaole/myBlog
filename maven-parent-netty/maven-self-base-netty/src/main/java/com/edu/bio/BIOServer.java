package com.edu.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

//BIO服务端
public class BIOServer {
    public static void main(String[] args) throws IOException {
        //线程池
        ThreadPoolExecutor poolExecutor =
                new ThreadPoolExecutor(10, 10, 5l, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        ServerSocket serverSocket = new ServerSocket(6666);
        System.out.println("服务端启动了");
        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("有一个客户端连接了");
            //交给线程池中的某一个线程去处理
            poolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    handler(socket);
                }
            });
        }
    }

    public static void handler(Socket socket) {
        byte[] buf = new byte[1024];
        InputStream inputStream = null;
        try {
            inputStream = socket.getInputStream();
            while (true) {
                int read = inputStream.read(buf);
                if (read != -1) {
                    System.out.println(new String(buf, 0, read));
                } else {
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            System.out.println("关闭client连接");
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
