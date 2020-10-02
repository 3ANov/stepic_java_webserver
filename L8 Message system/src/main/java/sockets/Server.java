package sockets;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server{
    ExecutorService pool;
    private final ServerSocketChannel serverSocketChannel;

    public Server(int port, int threadCount) throws IOException {
        this.serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.socket().bind(new InetSocketAddress(port));
        this.pool = Executors.newFixedThreadPool(threadCount);
    }




}
