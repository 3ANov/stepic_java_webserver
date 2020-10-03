package sockets;

import main.Main;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.logging.Logger;

public class Server {
    private static Logger log = Logger.getLogger(Server.class.getName());

    ExecutorService pool;
    private final int port;
    private final int threadCount;


    public Server(int port, int threadCount) {
        this.port = port;
        this.pool = Executors.newFixedThreadPool(threadCount);
        this.threadCount = threadCount;
    }

    public void start() {
        try (ServerSocket server = new ServerSocket(port)) {
            while (!server.isClosed()) {
                Socket client = server.accept();
                pool.execute(new ClientsSocketThread(client));
            }

        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
