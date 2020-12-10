package part2.chapter6;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;

/**
 * SingleThreadWebServer
 * <p/>
 * Sequential web server
 *
 * @author Brian Goetz and Tim Peierls
 */

public class SingleThreadWebServer {
    public static void main(String[] args) throws IOException {
        ServerSocket socket = new ServerSocket(80);
        while (true) {
            Socket connection = socket.accept();
            handleRequest(connection);
        }
    }

    private static void handleRequest(Socket connection) {
        // request-handling logic here
        String resp = "hello";
        byte[] bytes = resp.getBytes();
        try (OutputStream os = connection.getOutputStream();){

            os.write(bytes);
            os.flush();

            System.out.println("handle" + connection.getLocalAddress());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
