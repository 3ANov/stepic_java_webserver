package main;


import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.logging.Logger;


public class Main {
    private static Logger log = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws Exception {
        log.info("Server start");

        try(ServerSocketChannel serverSocketChannel = ServerSocketChannel.open()) {

            serverSocketChannel.socket().bind(new InetSocketAddress(5050));
            serverSocketChannel.configureBlocking(false);

            while (true) {
                SocketChannel socketChannel =
                        serverSocketChannel.accept();
                log.info("Server started");
                if (socketChannel != null) {
                    ByteBuffer buf = ByteBuffer.allocate(48);
                    int bytesRead = socketChannel.read(buf);

                    while (bytesRead != -1) {

                        buf.flip();  //make buffer ready for read

                        while (buf.hasRemaining()) {
                            System.out.print((char) buf.get()); // read 1 byte at a time
                        }

                        buf.clear(); //make buffer ready for writing
                        bytesRead = socketChannel.read(buf);
                    }
                }
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }



    }
}
